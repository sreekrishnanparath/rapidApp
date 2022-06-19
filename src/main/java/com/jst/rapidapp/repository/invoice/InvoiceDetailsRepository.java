package com.jst.rapidapp.repository.invoice;

import com.jst.rapidapp.beans.InvoiceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailsRepository extends JpaRepository<InvoiceDetails, Long> {
    InvoiceDetails saveAndFlush(InvoiceDetails invoiceDetails);

    InvoiceDetails findById(long id);

    List<InvoiceDetails> findAll();

    void deleteById(long id);
}
