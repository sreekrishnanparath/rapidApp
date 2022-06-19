package com.jst.rapidapp.service.invoice;

import com.jst.rapidapp.beans.InvoiceHeader;

import java.util.List;

public interface InvoiceHeaderService {
    InvoiceHeader createInvoiceHeader(InvoiceHeader invoiceHeader);
    void deleteInvoiceHeader(long invoiceHeaderId);
    InvoiceHeader getInvoiceHeaderById(long invoiceHeaderId);
    List<InvoiceHeader> getInvoiceHeaderList();
    void updateInvoiceHeader(long invoiceHeaderId, InvoiceHeader invoiceHeader);

}
