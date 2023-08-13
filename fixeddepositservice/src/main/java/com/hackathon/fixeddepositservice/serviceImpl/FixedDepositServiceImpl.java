package com.hackathon.fixeddepositservice.serviceImpl;

import com.hackathon.fixeddepositservice.feginclient.InterestRate;
import com.hackathon.fixeddepositservice.modal.DepositsRequest;
import com.hackathon.fixeddepositservice.modal.FixedDepositsModal;
import com.hackathon.fixeddepositservice.repository.FixedDepositsRepo;
import com.hackathon.fixeddepositservice.service.FixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class FixedDepositServiceImpl implements FixedDepositService {

    @Autowired
    FixedDepositsRepo fixedDepositsRepo;
    
    @Autowired
    InterestRate interestrate;
    @Override
    public FixedDepositsModal addDepositDetails(DepositsRequest depositsRequest) {
        try{
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date depositDateVal = sdf.parse(depositsRequest.getDepositStartDate());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(depositDateVal);
            calendar.add(Calendar.DATE, depositsRequest.getTenure());
            String maturityDate = sdf.format(calendar.getTime());

        
            
            
            int tenureInMonths = depositsRequest.getTenure();
            
            double interestRateValue=interestrate.getInterestRate(depositsRequest.getTenure());
           
            double maturedAmount = depositsRequest.getDepositAmount() * Math.pow(1 + interestRateValue, tenureInMonths);
            FixedDepositsModal fixedDepositsModal =new  FixedDepositsModal.Builder()
            		.customerId(depositsRequest.getCustomerId())
                    .depositTenure(depositsRequest.getTenure())
                    .depositStartDate(depositsRequest.getDepositStartDate())
                    .depositAmount(depositsRequest.getDepositAmount())
                    .active("Y")
                    .depositMatured("N")
                    .maturedAmount(maturedAmount)
                    .interestAmount(maturedAmount - depositsRequest.getDepositAmount())
                    .maturityDate(maturityDate)
                    .interestRate(interestRateValue)
                    .build();
            fixedDepositsRepo.save(fixedDepositsModal);
            return fixedDepositsModal;
        }catch(Exception e){
           e.printStackTrace();
        }
        return null;
    }

   /* @Override
    public List<FixedDepositsModal> getAllFixedDeposits(String customerId, String depositId) {
        if(customerId != null && depositId != null){
            return fixedDepositsRepo.findByCustomerIdAndDepositId(Integer.valueOf(customerId), Integer.valueOf(depositId));
        }else if(customerId != null && depositId == null){
            return fixedDepositsRepo.findByCustomerId(Integer.valueOf(customerId));
        }else{
            return fixedDepositsRepo.findAll();
        }
    } */
}
