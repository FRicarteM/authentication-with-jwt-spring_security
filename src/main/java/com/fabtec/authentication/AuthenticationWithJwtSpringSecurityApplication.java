package com.fabtec.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthenticationWithJwtSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationWithJwtSpringSecurityApplication.class, args);
//		
//		 Map<String, PasswordEncoder> encoders = new HashMap<>();
//	        
//	        Pbkdf2PasswordEncoder pbkdf2Encoder =
//	        		new Pbkdf2PasswordEncoder(
//	    				"secret", 8, 185000,
//	    				SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
//	        
//	        encoders.put("pbkdf2", pbkdf2Encoder);
//	        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
//	        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
//	        
//	        String result1 = passwordEncoder.encode("admin123");
//	        String result2 = passwordEncoder.encode("admin234");
//	        System.out.println("My hash result1 " + result1);
//	        System.out.println("My hash result2 " + result2);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String result1 = passwordEncoder.encode("admin123");
		System.out.println("My hash result1 " + result1);
	}

}
