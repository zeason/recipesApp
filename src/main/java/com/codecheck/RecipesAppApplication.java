package com.codecheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.codecheck.mapper")
public class RecipesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesAppApplication.class, args);
	}
}
