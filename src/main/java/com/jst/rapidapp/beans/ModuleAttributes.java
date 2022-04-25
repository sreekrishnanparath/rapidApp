package com.jst.rapidapp.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ModuleAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long attributeId;

    private long companyId;

    private long moduleMasterId;
    @NotEmpty(message = "Atrribute's Description is required")
    private String attrDesc;

    private int inputControlType;

    private int attrType;

    private int attrLength;

    private String style;

    private String status;

    private boolean isActive;

    @CreationTimestamp
    private Timestamp createdDate;

    @CreatedBy
    private long createdBy;

    private int action;

    private String attrDependency ;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "lookup_ref_id")
//    private LookupMaster attrDependency;

}
