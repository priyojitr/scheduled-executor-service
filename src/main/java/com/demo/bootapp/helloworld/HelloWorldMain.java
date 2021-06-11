package com.demo.bootapp.helloworld;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class HelloWorldMain {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloWorldMain.class, args);
	}
	
	@PreDestroy
	public void shutingDown() {
		log.info("shutting down app");
	}
	
	
}
