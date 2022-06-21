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
public class DiscountGroup {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long id ;

    private String desc ;

    private String type;

    private double value;

    private String status;

    @CreationTimestamp
    private LocalDateTime statusDate;

    private boolean isActive;


}
