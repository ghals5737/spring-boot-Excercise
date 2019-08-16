package com.springboot1.webproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.springboot1.webproject.mapper")
public class WepApplication {

	public static void main(String[] args) {
		SpringApplication.run(WepApplication.class, args);
	}

}
