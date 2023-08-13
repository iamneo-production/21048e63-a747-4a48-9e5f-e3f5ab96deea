package com.hackathon.fixeddepositservice.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@FeignClient(name="NOTIFICATION-SERVICE")
public interface NotificationServiceProxy {
	
	@PostMapping("/api/notifications/send_reminder")
	public void sendReminder(@RequestBody String formattedLocalDate);

	
}
