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
    public ModuleAttributes(long attributeId, long companyId, long moduleMasterId, String attrDesc,int inputControlType, int attrType, int attrLength, String style, String status, boolean isActive, Timestamp createdDate, long createdBy,int action,
                            String attrDependency) {
        this.attributeId = attributeId;
        this.companyId = companyId;
        this.moduleMasterId = moduleMasterId;
        this.attrDesc = attrDesc;
        this.inputControlType  = inputControlType;
        this.attrType = attrType;
        this.attrLength = attrLength;
        this.style = style;
        this.status = status;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.action = action;
        this.attrDependency = attrDependency;
    }
}
