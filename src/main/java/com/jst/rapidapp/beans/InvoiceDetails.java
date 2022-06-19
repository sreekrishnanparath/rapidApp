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
public class InvoiceDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long lineId ;

    private long transId ;

    private Date transDt;

    private long itemId;

    private long branchId;

    private double amount;

    private double discount ;

    private double vatAmount ;

    private double netAmount ;

    private long discountId;

    private String status;

    private String statusBy;

}
