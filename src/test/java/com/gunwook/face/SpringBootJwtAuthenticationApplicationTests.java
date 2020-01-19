package com.gunwook.face;

import com.gunwook.face.grpc.GrpcClient;
import com.gunwook.face.security.jwt.JwtProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class SpringBootJwtAuthenticationApplicationTests {

	@Autowired
	private GrpcClient client;

	private static final Logger logger = LoggerFactory.getLogger(SpringBootJwtAuthenticationApplicationTests.class);


	@Test
	public void test() {
		Iterator<ChatModel> itr = client.test(1);

		while( itr.hasNext() ) {
			ChatModel model = itr.next();

			logger.info(model.toString());
		}
	}

}
