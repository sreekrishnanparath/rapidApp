package com.jst.rapidapp.beans;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

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


}
