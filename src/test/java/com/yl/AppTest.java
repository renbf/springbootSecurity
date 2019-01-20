package com.yl;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppTest {

	@Test
	public void test() {
		String password = "1";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String enPassword = encoder.encode(password);
        System.out.println(enPassword);
        //$2a$10$QR35p9gbZ0Kh9v9qFTI5SepBpj0z8QfmQzBH3JeNnOuMiwL5AUaIa
        //$2a$10$.1v1zJs5gZ65r5rqkKik0Oj8jfYUtQs0rFlZq2I5L4hXHgroYD/B6
        //$2a$04$jB3hwaqmDhV/hjopPsK4du0ewP3HPfSgjRVd7hiKEgRutbXYE51NG
        //$2a$10$Fnlh5FlIy.0dpFXOBNB9Q.zaUvQZf6YvxOlEuEosoSVaACya9rKM6
	}
}
