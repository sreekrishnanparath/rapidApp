package com.jst.rapidapp.dao.invoice;

import com.jst.rapidapp.beans.InvoiceDetails;
import com.jst.rapidapp.beans.InvoiceHeader;
import com.jst.rapidapp.repository.invoice.InvoiceDetailsRepository;
import com.jst.rapidapp.repository.invoice.InvoiceHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceHeaderDao {

    @Autowired
    InvoiceHeaderRepository invoiceHeaderRepository;


    @Autowired
    InvoiceDetailsRepository invoiceDetailsRepository;

    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader) {

        InvoiceHeader invoiceHeaderResponse = invoiceHeaderRepository.saveAndFlush(invoiceHeader);

//        List<InvoiceDetails> invoiceDetails = invoiceHeader.getInvoiceDetailsList();
//        if(invoiceDetails.size() > 0 ){
//            for(InvoiceDetails invoiceDetail : invoiceDetails){
//                invoiceDetail.s
//                invoiceDetailsRepository.saveAndFlush(invoiceDetail);
//            }
//        }
        invoiceHeader.setStatus("CREATED");
        return invoiceHeaderResponse;
    }


    public void deleteInvoiceHeader(long id) {

        invoiceHeaderRepository.deleteById(id);
    }


    public InvoiceHeader getInvoiceHeaderById(long id) {
        return invoiceHeaderRepository.findById(id);
    }


    public List<InvoiceHeader> getInvoiceHeaderList() {
        return invoiceHeaderRepository.findAll();
    }

    public void updateInvoiceHeader(long id, InvoiceHeader invoiceHeader){
        InvoiceHeader existingInvoiceHeader = invoiceHeaderRepository.findById(id);
        if(existingInvoiceHeader != null){
            invoiceHeaderRepository.save(invoiceHeader);
        }

    }

}
