package com.example.CustomerService.FeginClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CustomerService.dto.NotificationRequestData;



@FeignClient(name="NOTIFICATION-SERVICE")
public interface NotificationServiceProxy {
	@PostMapping("/api/notifications/send_notification")
	public ResponseEntity<Object> sendNotification(@RequestBody NotificationRequestData notificationRequestData);

}
