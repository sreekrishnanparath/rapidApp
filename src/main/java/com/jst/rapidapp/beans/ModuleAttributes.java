package com.jst.rapidapp.beans;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class ModuleAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long attributeId;

    private long companyId;

    private long moduleMasterId;

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

    public ModuleAttributes() {
    }

    public ModuleAttributes(long attributeId, long companyId, long moduleMasterId, String attrDesc,int inputControlType, int attrType, int attrLength, String style, String status, boolean isActive, Timestamp createdDate, long createdBy) {
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
    }

    public long getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(long attributeId) {
        this.attributeId = attributeId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public long getModuleMasterId() {
        return moduleMasterId;
    }

    public void setModuleMasterId(long moduleMasterId) {
        this.moduleMasterId = moduleMasterId;
    }

    public String getAttrDesc() {
        return attrDesc;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    public int getAttrType() {
        return attrType;
    }

    public void setAttrType(int attrType) {
        this.attrType = attrType;
    }

    public int getAttrLength() {
        return attrLength;
    }

    public void setAttrLength(int attrLength) {
        this.attrLength = attrLength;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public int getInputControlType() {
        return inputControlType;
    }

    public void setInputControlType(int inputControlType) {
        this.inputControlType = inputControlType;
    }
}
