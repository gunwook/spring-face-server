package com.gunwook.face.controller;

import java.util.*;

import javax.validation.Valid;

import com.gunwook.face.grpc.GrpcClient;
import com.gunwook.face.helper.UploadHelper;
import com.gunwook.face.message.request.EmailForm;
import com.gunwook.face.message.response.JwtResponse;
import com.gunwook.face.message.response.ResponseMessage;
import com.gunwook.face.message.response.ResponseUserMessage;
import com.gunwook.face.security.jwt.JwtProvider;
import com.gunwook.face.security.services.UserPrinciple;
import com.gunwook.face.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.gunwook.face.message.request.LoginForm;
import com.gunwook.face.message.request.SignUpForm;
import com.gunwook.face.model.Role;
import com.gunwook.face.model.RoleName;
import com.gunwook.face.model.User;
import com.gunwook.face.repository.RoleRepository;
import com.gunwook.face.repository.UserRepository;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	private Logger logger = LoggerFactory.getLogger(AuthRestAPIs.class);

	@Autowired
	EmailUtils emailUtils;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@Autowired
	UploadHelper uploadHelper;

	@Autowired
	GrpcClient client;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid LoginForm loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();

		String jwt = jwtProvider.generateJwtToken(userDetails.getEmail());

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername() , 200 , userDetails.getId() , userDetails.getEmail()));
	}

	@PostMapping("/email")
	public ResponseEntity<?> authenticateFindUser(@Valid EmailForm emailForm) {
		emailUtils.send(Collections.singletonList(emailForm.getEmail()),  emailForm.getSubject(), emailForm.getContent());

		return ResponseEntity.ok(new ResponseMessage("Send Email" , 200));
	}

	@GetMapping("")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> checkAuthUser() {
		return ResponseEntity.ok(new ResponseMessage("success" , 200));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestParam("files") List<MultipartFile> files , @Valid SignUpForm signUpRequest) {
		try {

			if (userRepository.existsByEmail(signUpRequest.getEmail())) {
				return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!" , 412),
						HttpStatus.BAD_REQUEST);
			}

			List<String> imgs = new ArrayList<>();

			if (!files.isEmpty()) {
				imgs = uploadHelper.uploadFiles(files);

				if (null == imgs || imgs.isEmpty()) {
					return new ResponseEntity<>(new ResponseMessage("Fail -> Image Upload Failed!",500),
							HttpStatus.BAD_REQUEST);
				}
			}

			// Creating user's account
			User user = new User(signUpRequest.getName(), signUpRequest.getNickname(), signUpRequest.getEmail(),
					encoder.encode(signUpRequest.getPassword()), signUpRequest.getGender(), signUpRequest.getMessage(), files.isEmpty() ? ""  : imgs.get(0), System.currentTimeMillis() , signUpRequest.getFcmToken());

			Set<Role> roles = new HashSet<>();

			Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(userRole);

			user.setRoles(roles);
			userRepository.save(user);

			String jwt = jwtProvider.generateJwtToken(user.getEmail());

			return new ResponseEntity<>(new ResponseUserMessage(jwt, user.getId() , 200, user.getEmail(), user.getName()), HttpStatus.OK);
		}catch (Exception e) {
			logger.error(e.getMessage());

			return new ResponseEntity<>(new ResponseMessage("Fail -> Failed while in progress.",500),
					HttpStatus.BAD_REQUEST);
		}
	}
}