package com.demo.bootapp.helloworld.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bootapp.helloworld.execsvc.ExecutorServiceManager;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class HomeController {
	
	@GetMapping(value = "/")
	public String hello() {
		log.info("class -- {}", this.getClass().getTypeName());
		return "new controller - " + this.getClass().toString();
	}
	
	@GetMapping(value = "/new")
	public String hello1() {
		log.info("returning current token");
		return ExecutorServiceManager.token;
	}
		
	@GetMapping(value = "/h")
	public String hello2() {
		log.info("halting exec svc");
		ExecutorServiceManager.execStop();
		return "thread halting";
	}
		
	@GetMapping(value = "/t")
	public String callExecSvc() {
		log.info("intiate exec call from controller");
		ExecutorServiceManager.execSvc();
		return "starting thread";
	}
}
