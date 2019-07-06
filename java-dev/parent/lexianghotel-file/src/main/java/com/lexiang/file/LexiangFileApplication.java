package com.lexiang.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude=DataSourceAutoConfiguration.class)
public class LexiangFileApplication {

	public static void main(String[] args) {
		SpringApplication.run(LexiangFileApplication.class, args);
	}
}
