//package com.fabtec.authentication.OBSERVACOES;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.catalina.User;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
//import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm;
//
//@SuppressWarnings("all")
//public class OBSERVACOES {
//
//exemplo de método para codificar password
//exemplo classe USER(nomeUser, password)
//Este é um exemplo geral que deve ser melhor adaptado nas devidas classes classe(service, models, controller, mapper).
//    
//	public void saveLoginPassword(User user) {
//    
//        Map<String, PasswordEncoder> encoders = new HashMap<>();
//        Pbkdf2PasswordEncoder pbkdf2Encoder =
//        		new Pbkdf2PasswordEncoder("", 8, 185000, SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
//        
//        encoders.put("pbkdf2", pbkdf2Encoder);
//        DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
//        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);
//        
//        User user = User.builder()
//        		.nomeUser(user.getNomeUser)
//        		.password(passwordEncoder.encode(user.getPassword()))
//        		.build;
//        repository.save(user);
//	}
//	
//}
