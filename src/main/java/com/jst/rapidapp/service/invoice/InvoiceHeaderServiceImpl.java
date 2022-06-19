package com.jst.rapidapp.service.invoice;


import com.jst.rapidapp.beans.InvoiceHeader;
import com.jst.rapidapp.dao.invoice.InvoiceHeaderDao;
import com.jst.rapidapp.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceHeaderServiceImpl implements InvoiceHeaderService {


    @Autowired
    InvoiceHeaderDao invoiceHeaderDao;

    @Override
    public InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader) {
        return invoiceHeaderDao.createInvoiceHeader(invoiceHeader);
    }


    @Override
    public void deleteInvoiceHeader(long id) {
        invoiceHeaderDao.deleteInvoiceHeader(id);
    }

    @Override
    public InvoiceHeader getInvoiceHeaderById(long id) {
        return invoiceHeaderDao.getInvoiceHeaderById(id);
    }

    @Override
    public List<InvoiceHeader> getInvoiceHeaderList() {
        return invoiceHeaderDao.getInvoiceHeaderList();
    }

    @Override
    public void updateInvoiceHeader(long id, InvoiceHeader invoiceHeader) {
        invoiceHeaderDao.updateInvoiceHeader(id, invoiceHeader);
    }


}

