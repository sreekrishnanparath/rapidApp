package com.jst.rapidapp.service.transaction;


import com.jst.rapidapp.beans.RapidTransactions;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TransactionService {

    public RapidTransactions createTransaction(RapidTransactions transactions);
    public RapidTransactions findTransactionById(long id);
    public List<RapidTransactions> findTransactionByCompanyId(long id);
    public List<RapidTransactions> findTransactionByModuleMasterId(long id);
    public List<RapidTransactions> findByCompanyIdAndModuleMasterId(long companyId,long moduleMasterId);

}
