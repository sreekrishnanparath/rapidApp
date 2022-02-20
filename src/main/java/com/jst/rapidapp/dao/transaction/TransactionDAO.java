package com.jst.rapidapp.dao.transaction;


import com.jst.rapidapp.beans.ModuleMaster;
import com.jst.rapidapp.beans.RapidTransactions;
import com.jst.rapidapp.repository.module.ModuleRepository;
import com.jst.rapidapp.repository.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionDAO {

    @Autowired
    TransactionRepository transactionRepository;


    public RapidTransactions saveTransaction(RapidTransactions transactions) {
        return transactionRepository.saveAndFlush(transactions);
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
        return transactionRepository.findByCompanyIdAndModuleMasterId(companyId,moduleMasterId);
    }
}
