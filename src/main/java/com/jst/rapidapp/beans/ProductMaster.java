package com.jst.rapidapp.beans;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="product_master")
public class ProductMaster {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long productId;

    private long branchId;

    private long supplierId ;

    private long discountId;

    private String shortDesc;

    private String longDesc;

    private double cost;

    private double sellingPrice ;

    private String status;

    @CreationTimestamp
    private LocalDateTime statusDate;

    private String createdBy ;

    @CreationTimestamp
    private LocalDateTime createdDate;

    private boolean isActive;

}
