package com.hackathon.notificationservice.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.hackathon.notificationservice.modal.NotificationModal;


public interface NotificationRepository extends JpaRepository<NotificationModal, Long> {

	@Query(value = "SELECT notification_modal FROM NotificationModal notification_modal WHERE notification_modal.maturity_date =:maturity_date ")
	List<NotificationModal> findByMaturity_date(String maturity_date);

}
