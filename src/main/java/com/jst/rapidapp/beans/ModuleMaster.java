package com.jst.rapidapp.beans;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
//tghompson
@Entity
public class ModuleMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long moduleId;

    private long companyId;

    private String moduleDesc;

    private String status;

    private boolean isActive;

    @CreationTimestamp
    private Timestamp createdDate;

    @CreatedBy
    private long createdBy;

    private long totalTrans;

    public ModuleMaster() {
    }

    public ModuleMaster(long moduleId, long comapnyId, String moduleDesc, String status, boolean isActive, Timestamp createdDate, long createdBy, int totalTrans) {
        this.moduleId = moduleId;
        this.companyId = comapnyId;
        this.moduleDesc = moduleDesc;
        this.status = status;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.totalTrans = totalTrans;
    }

    public ModuleMaster(long comapnyId,long moduleId, String moduleDesc, long totalTrans) {
        this.moduleId = moduleId;
        this.moduleDesc = moduleDesc;
        this.totalTrans = totalTrans;
        this.companyId = comapnyId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getModuleDesc() {
        return moduleDesc;
    }

    public void setModuleDesc(String moduleDesc) {
        this.moduleDesc = moduleDesc;
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

    public long getTotalTrans() {
        return totalTrans;
    }

    public void setTotalTrans(long totalTrans) {
        this.totalTrans = totalTrans;
    }
}
