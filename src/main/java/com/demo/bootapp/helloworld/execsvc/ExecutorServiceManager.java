package com.demo.bootapp.helloworld.execsvc;

import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ExecutorServiceManager {
	
	static ScheduledExecutorService execService;
	public static String token;

	private static void run() {
		token = UUID.randomUUID().toString();
		log.info("get new token :: {}", token);
	}
	
	public static void execSvc() {
		log.info("setting exec svc");
		execService = Executors.newSingleThreadScheduledExecutor();
		execService.scheduleAtFixedRate(ExecutorServiceManager::run, 0, 10, TimeUnit.SECONDS);
	}
	
	public static void execStop() {
		log.info("stopping exec svc");
		execService.shutdown();
	}
}
