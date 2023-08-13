package com.hackathon.notificationservice.service;


import com.hackathon.notificationservice.dto.NotificationRequestData;

public interface INotificationService {

	void sendFixedDepositeCretionNotification(NotificationRequestData notificationRequestData);

	void sendMaturityNotification(String maturityDate);
}
