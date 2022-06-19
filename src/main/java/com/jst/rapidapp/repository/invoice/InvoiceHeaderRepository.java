package com.jst.rapidapp.repository.invoice;

import com.jst.rapidapp.beans.InvoiceHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeader, Long> {
    InvoiceHeader saveAndFlush(InvoiceHeader invoiceHeader);

    InvoiceHeader findById(long id);

    List<InvoiceHeader> findAll();

    void deleteById(long id);
}
