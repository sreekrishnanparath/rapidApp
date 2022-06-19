package com.jst.rapidapp.dao.invoice;

import com.jst.rapidapp.beans.InvoiceHeader;
import com.jst.rapidapp.beans.ProductMaster;
import com.jst.rapidapp.repository.invoice.InvoiceHeaderRepository;
import com.jst.rapidapp.repository.item.ItemRepository;
import com.jst.rapidapp.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InvoiceHeaderDao {
    @Autowired
    InvoiceHeaderRepository invoiceHeaderRepository;



    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader) {
        invoiceHeader.setStatus("CREATED");
        return invoiceHeaderRepository.saveAndFlush(invoiceHeader);
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
