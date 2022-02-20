package com.jst.rapidapp.service.transaction;

import com.jst.rapidapp.beans.RapidTransactions;
import com.jst.rapidapp.dao.transaction.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionDAO transactionDAO;

    @Override
    public RapidTransactions createTransaction(RapidTransactions transactions) {
        return transactionDAO.saveTransaction(transactions);
    }

    @Override
    public RapidTransactions findTransactionById(long id) {
        return transactionDAO.getTransactionById(id);
    }

    @Override
    public List<RapidTransactions> findTransactionByCompanyId(long id) {
        return transactionDAO.getTransactionByCompanyId(id);
    }

    @Override
    public List<RapidTransactions> findTransactionByModuleMasterId(long id) {
        return transactionDAO.getTransactionByModuleMasterId(id);
    }

    @Override
    public List<RapidTransactions> findByCompanyIdAndModuleMasterId(long companyId, long moduleMasterId) {
        return transactionDAO.getTransactionByCompanyIdAndModuleMasterId(companyId,moduleMasterId);
    }
}
