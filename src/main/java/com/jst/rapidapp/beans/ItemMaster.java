package com.jst.rapidapp.beans;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="item_master")
public class ItemMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long itemId ;

    private long itemClassId ;

    private long branchId;

    private double cost;

    private double sellingPrice ;

    private double itemQty  ;

    private double onStock  ;

    private double shadowStockIn  ;

    private double shadowStockOut  ;

    private String status;

    @CreationTimestamp
    private LocalDateTime statusDate;

    private String createdBy ;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    private ProductMaster product;


}
