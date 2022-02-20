package com.jst.rapidapp.repository.transaction;


import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.RapidTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<RapidTransactions, Long> {

    RapidTransactions saveAndFlush(RapidTransactions transactions);
    RapidTransactions findById(long id);
    List<RapidTransactions> findByCompanyId(long id);
    List<RapidTransactions> findByModuleMasterId(long id);
    List<RapidTransactions> findByCompanyIdAndModuleMasterId(long companyId,long moduleMasterId);
}
