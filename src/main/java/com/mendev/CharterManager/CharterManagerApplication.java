package com.mendev.CharterManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//disabled security screen
@SpringBootApplication (exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class CharterManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CharterManagerApplication.class, args);
	}

}
