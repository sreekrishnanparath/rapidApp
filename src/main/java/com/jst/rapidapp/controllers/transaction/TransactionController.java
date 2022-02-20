package com.jst.rapidapp.controllers.transaction;


import com.jst.rapidapp.beans.Company;
import com.jst.rapidapp.beans.RapidTransactions;
import com.jst.rapidapp.repository.company.CompanyRepository;
import com.jst.rapidapp.service.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rapidapp/trans/")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/create")
    public ResponseEntity<RapidTransactions> saveCompany(@RequestBody RapidTransactions rapidTransactions){
        RapidTransactions rapidTransactionResponse = transactionService.createTransaction(rapidTransactions);
        return new ResponseEntity<RapidTransactions>(rapidTransactionResponse,HttpStatus.CREATED);
    }

    @PostMapping("/{transId}")
    public ResponseEntity<RapidTransactions> getTransactionById(@PathVariable long transId){
        RapidTransactions rapidTransactions = transactionService.findTransactionById(transId);
        return new ResponseEntity<RapidTransactions>(rapidTransactions,HttpStatus.OK);
    }

    @PostMapping("/company/{companyId}")
    public ResponseEntity<List<RapidTransactions>> getTransactionByCompanyId(@PathVariable long companyId){
        List<RapidTransactions> rapidTransactions = transactionService.findTransactionByCompanyId(companyId);
        return new ResponseEntity<List<RapidTransactions>>(rapidTransactions,HttpStatus.OK);
    }

    @PostMapping("/module/{moduleMasterId}")
    public ResponseEntity<List<RapidTransactions>> getTransactionByModuleMasterId(@PathVariable long moduleMasterId){
        List<RapidTransactions> rapidTransactions = transactionService.findTransactionByModuleMasterId(moduleMasterId);
        return new ResponseEntity<List<RapidTransactions>>(rapidTransactions,HttpStatus.OK);
    }

    @PostMapping("/comMod/{companyId}/{moduleMasterId}")
    public ResponseEntity<List<RapidTransactions>> getTransactionByCompanyIdAndModuleMasterId(@PathVariable long companyId,@PathVariable long moduleMasterId){
        List<RapidTransactions> rapidTransactions = transactionService.findByCompanyIdAndModuleMasterId(companyId,moduleMasterId);
        return new ResponseEntity<List<RapidTransactions>>(rapidTransactions,HttpStatus.OK);
    }
}
