package com.hackathon.notificationservice;

import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;




@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients	
public class NotificationServiceApplication extends TimerTask {

	Logger log= LoggerFactory.getLogger(NotificationServiceApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new NotificationServiceApplication(), 0, 1000);

	}

	@Override
	public void run() {
		log.info("NotificationServiceApplication: run(): Searching Maturity ... ");

		System.out.println("Scheduled task executed ");

	}
}
