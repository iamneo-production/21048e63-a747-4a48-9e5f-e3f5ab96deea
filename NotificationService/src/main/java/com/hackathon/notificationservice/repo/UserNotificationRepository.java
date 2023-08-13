package com.hackathon.notificationservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hackathon.notificationservice.modal.UserNotificationModal;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotificationModal, Long> {

}
