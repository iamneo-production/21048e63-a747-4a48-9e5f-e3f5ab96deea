package com.hackathon.fixeddepositservice.repository;

import com.hackathon.fixeddepositservice.modal.FixedDepositsModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FixedDepositsRepo extends JpaRepository<FixedDepositsModal, Integer> {

    List<FixedDepositsModal> findByCustomerId(int customerId);

    List<FixedDepositsModal> findByCustomerIdAndDepositId(int customerId, int depositId);

	

	List<FixedDepositsModal> findByMaturityDate(String formattedLocalDate);
}
