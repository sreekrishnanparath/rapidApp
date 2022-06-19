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
@Table(name="invoice_details")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long lineId ;

    private Date transDt;

    private long itemId;

    private long branchId;//FK

    private double amount;

    private double discount ;

    private double vatAmount ;

    private double netAmount ;

    private long discountId;

    private String status;

    private String statusBy;


}
