package com.hackathon.interestrateservice.repository;

import com.hackathon.interestrateservice.Modal.InterestRateModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InterestRateRepo extends JpaRepository<InterestRateModal, Integer> {
    @Query(value = "select s.INTEREST_RATE from interest_rate_master s where s.FROM_DAYS <= :tenure and s.TO_DAYS >= :tenure",nativeQuery = true)
    Double getInterestRate(@Param("tenure") int tenure);
}
