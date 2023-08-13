package com.hackathon.notificationservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.notificationservice.dto.FixedDepositsModal;
import com.hackathon.notificationservice.dto.NotificationRequestData;
import com.hackathon.notificationservice.service.INotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

	Logger log= LoggerFactory.getLogger(NotificationController.class);
	
	@Autowired
	private INotificationService iNotificationService;

	@PostMapping("/send_notification")
	public ResponseEntity<Object> sendNotification(@RequestBody NotificationRequestData notificationRequestData) {
		System.out.println("notificationRequestData ==========" + notificationRequestData.getCustomer_id());
		log.info("NotificationController: sendNotification():Data: " + notificationRequestData.toString());
		iNotificationService.sendFixedDepositeCretionNotification(notificationRequestData);
		return new ResponseEntity<>(notificationRequestData, HttpStatus.OK);
	}
	
	@PostMapping("/send_reminder")
	public void sendReminder(@RequestBody String formattedLocalDate)
	{
		iNotificationService.sendMaturityNotification(formattedLocalDate);
		//return new ResponseEntity<>(fixedDepositsModal, HttpStatus.OK);
	}

}
