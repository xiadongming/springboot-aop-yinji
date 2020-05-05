package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@MapperScan("com.example.demo.dtomapper")//规定，只能配置对应的dao层，范围不能太大
@SpringBootApplication
public class SpringbootBootrabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBootrabbitmqApplication.class, args);
		
	}

}
