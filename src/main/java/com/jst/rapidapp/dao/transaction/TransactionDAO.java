package com.jst.rapidapp.dao.transaction;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.RapidTransactions;
import com.jst.rapidapp.repository.module.ModuleRepository;
import com.jst.rapidapp.repository.transaction.TransactionRepository;
import com.jst.rapidapp.utils.commonConstants.mail.EmailService;
import com.jst.rapidapp.utils.redisCache.RedisUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.List;

@Component
public class TransactionDAO {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    RedisUtility redisUtility;

    @Autowired
    EmailService emailService;


    public RapidTransactions saveTransaction(RapidTransactions transactions) {
        RapidTransactions createdTransaction = transactionRepository.saveAndFlush(transactions);
//        try {
//            emailService.sendEmail("Rapid App Transaction",createdTransaction);
//        } catch (MessagingException e) {
//            e.printStackTrace();
//        }
        return createdTransaction;
    }

    public RapidTransactions getTransactionById(long id) {
        return transactionRepository.findById(id);
    }

    public List<RapidTransactions> getTransactionByCompanyId(long id) {
        return transactionRepository.findByCompanyId(id);
    }

    public List<RapidTransactions> getTransactionByModuleMasterId(Long id) {
        return transactionRepository.findByModuleMasterId(id);
    }

    public List<RapidTransactions> getTransactionByCompanyIdAndModuleMasterId(long companyId,long moduleMasterId) {

//        List<RapidTransactions> rapidTransactionsList = redisUtility.getValue("test");
//
//        if(rapidTransactionsList==null){
//            System.out.println("From Repo###");
//            rapidTransactionsList = transactionRepository.findByCompanyIdAndModuleMasterId(companyId,moduleMasterId);
//            if(rapidTransactionsList!=null){
//                redisUtility.setValue("test",rapidTransactionsList);
//                return rapidTransactionsList;
//            }
//        }
//        System.out.println("From cache###"+rapidTransactionsList);
//        return rapidTransactionsList;

        return transactionRepository.findByCompanyIdAndModuleMasterId(companyId,moduleMasterId);
    }


}
