package com.jst.rapidapp.beans;

import io.lettuce.core.support.caching.CacheAccessor;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="invoice_header")
public class InvoiceHeader {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long transId;

    private Date transDt;

    private long branchId;

    private String transType;

    private double grossAmount;

    private double totalDiscount;

    private double totalVat;

    private double netAmount;

    private long discountId;

    private String status;

    private String statusBy;

    private LocalDateTime transTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "trans_id", nullable = false)
    private List<InvoiceDetails> invoiceDetails = new ArrayList<InvoiceDetails>();

}
