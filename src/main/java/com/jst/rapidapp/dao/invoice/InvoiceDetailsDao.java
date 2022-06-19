package com.jst.rapidapp.dao.invoice;

import com.jst.rapidapp.beans.InvoiceDetails;
import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.repository.invoice.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceDetailsDao {
    @Autowired
    InvoiceDetailsRepository invoiceDetailsRepository;



    public InvoiceDetails createInvoiceDetails(InvoiceDetails invoiceDetails) {
        invoiceDetails.setStatus("CREATED");
        return invoiceDetailsRepository.saveAndFlush(invoiceDetails);
    }


    public void deleteInvoiceDetails(long id) {

        invoiceDetailsRepository.deleteById(id);
    }


    public InvoiceDetails getInvoiceDetailsById(long id) {
        return invoiceDetailsRepository.findById(id);
    }


    public List<InvoiceDetails> getInvoiceDetailsList() {
        return invoiceDetailsRepository.findAll();
    }

    public void updateInvoiceDetails(long id, InvoiceDetails invoiceDetails){
        InvoiceDetails existingInvoiceDetails = invoiceDetailsRepository.findById(id);
        if(existingInvoiceDetails != null){
            invoiceDetailsRepository.save(invoiceDetails);
        }

    }

}
