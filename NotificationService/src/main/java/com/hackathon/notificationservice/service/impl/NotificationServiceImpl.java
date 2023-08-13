package com.hackathon.notificationservice.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.hackathon.notificationservice.FeginClient.CustomerServiceProxy;
import com.hackathon.notificationservice.FeginClient.FixedDepositProxy;
import com.hackathon.notificationservice.dto.Customer;
import com.hackathon.notificationservice.dto.FixedDepositsModal;
import com.hackathon.notificationservice.dto.NotificationRequestData;
import com.hackathon.notificationservice.modal.NotificationModal;
import com.hackathon.notificationservice.modal.UserNotificationModal;
import com.hackathon.notificationservice.repo.NotificationRepository;
import com.hackathon.notificationservice.repo.UserNotificationRepository;
import com.hackathon.notificationservice.service.INotificationService;




@Service
public class NotificationServiceImpl implements INotificationService {
	
	Logger log= LoggerFactory.getLogger(NotificationServiceImpl.class);
			

	@Autowired
	private final JavaMailSender mailSender;

	@Autowired
	private final NotificationRepository notificationRepository;

	@Autowired
	private UserNotificationRepository userNotificationRepository;
	
	@Autowired
	private CustomerServiceProxy customerServiceProxy;
	
	@Autowired
	private FixedDepositProxy fixedDepositProxy; 

	public NotificationServiceImpl() {
		this.mailSender = null;
		this.notificationRepository = null;
		this.userNotificationRepository = null;

	}

//	@Autowired
//	public NotificationServiceImpl(JavaMailSender mailSender) {
//		this.mailSender = mailSender;
//	}

	@Override
	public void sendFixedDepositeCretionNotification(@RequestBody NotificationRequestData notificationRequestData) {
		System.out.println("cid in notiservice" + notificationRequestData.getCustomer_id());
		Customer customer = customerServiceProxy.getcustomer(Integer.valueOf(notificationRequestData.getCustomer_id()));
		//System.out.println(customer);
		//Customer customer = null;
		log.info("EMailService:sendFixedDepositeCretionNotification(-): Data: " + notificationRequestData.toString());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(notificationRequestData.getTo());
		String messageSubject = "Fixed Deposite Created Successfully";
		message.setSubject(messageSubject);
		String messageBody = "Hi! " + customer.getFirstName() + ",\n" + "\n"
				+ "A Fixed Deposite has been created succesfully. Please find the details below.\n" + "\n"
				+ "Deposit Amount: " + notificationRequestData.getDeposit_amount() + "\n" + "Maturity Amount: "
				+ notificationRequestData.getMaturity_amount() + "\n" + "Maturity Date: "
				+ notificationRequestData.getMaturity_date() + " \n" + "Customer Name: "
				+ customer.getFirstName() + "\n" 
				+ "\n" + "     \n" + "Thank you for Banking with us.";
		message.setText(messageBody);
		log.info("EMailService:sendFixedDepositeCretionNotification(-): Sending EMail ..." + message.toString());

		//mailSender.send(message);
		log.info("EMailService:sendFixedDepositeCretionNotification(-): EMail Sent Successfully...");

	}

	@Override
	public void sendMaturityNotification(String maturityDate) {
		log.info("EMailService:sendMaturityNotification(-): Data: " + maturityDate);

		List<FixedDepositsModal> maturityData = fixedDepositProxy.getFixedDepositsByMaturityDate(maturityDate);

		Customer userdata = null;
		if (maturityData != null) 
		{


		for (FixedDepositsModal fd : maturityData)  
		{
			 userdata = customerServiceProxy.getcustomer(fd.getCustomerId());
			 
			

			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(userdata.getUserEmail());
			String messageSubject = "Fixed Deposite Matured";
			message.setSubject(messageSubject);
			String messageBody = "Hi! " + userdata.getFirstName() + ",\n" + "\n"
					+ "A Fixed Deposite has Matured. Please find the details below.\n" + "\n" + "Customer Name: "
					+ userdata.getFirstName() + "\n" + "\n" + "Deposit Amount:"
					+ fd.getDepositAmount() + "\n" + "Deposite Date:"
					+ fd.getDepositStartDate() + "\n" + "Maturity Amount:"
					+ fd.getMaturedAmount() + "\n" + "Maturity Date:"
					+ fd.getMaturityDate() + "\n" + "\n" + "     \n"
					+ "Thank you for Banking with us.";
			message.setText(messageBody);
			log.info("EMailService:sendMaturityNotification(-): Sending EMail ..." + message.toString());

			//mailSender.send(message);
			log.info("EMailService:sendMaturityNotification(-): EMail Sent Successfully...");
		}
		}
		else {
			return;
		}

	}

}


















//log.info("EMailService:sendMaturityNotification(-): Data: " + maturityDate);
//
//List<FixedDepositsModal> maturityData = fixedDepositProxy.getFixedDepositsByMaturityDate(maturityDate);
//
//Customer userdata = null;
//if (maturityData != null) 
//{
//
//
//for (FixedDepositsModal fd : maturityData)  
//{
//	 userdata = customerServiceProxy.getcustomer(fd.getCustomerId());
//	 
//	
//
//	SimpleMailMessage message = new SimpleMailMessage();
//	message.setTo(userdata.getUserEmail());
//	String messageSubject = "Fixed Deposite Matured";
//	message.setSubject(messageSubject);
//	String messageBody = "Hi! " + userdata.getFirstName() + ",\n" + "\n"
//			+ "A Fixed Deposite has Matured. Please find the details below.\n" + "\n" + "Customer Name: "
//			+ userdata.getFirstName() + "\n" + "\n" + "Deposit Amount:"
//			+ fd.getDepositAmount() + "\n" + "Deposite Date:"
//			+ fd.getDepositStartDate() + "\n" + "Maturity Amount:"
//			+ fd.getMaturedAmount() + "\n" + "Maturity Date:"
//			+ fd.getMaturityDate() + "\n" + "\n" + "     \n"
//			+ "Thank you for Banking with us.";
//	message.setText(messageBody);
//	log.info("EMailService:sendMaturityNotification(-): Sending EMail ..." + message.toString());
//
//	mailSender.send(message);
//	log.info("EMailService:sendMaturityNotification(-): EMail Sent Successfully...");
//}
//}
