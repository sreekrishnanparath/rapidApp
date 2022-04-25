package com.jst.rapidapp.beans;


import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
//tghompson
@Entity
public class ModuleMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long moduleId;

    private long companyId;
    @NotEmpty(message = "Module Description is required")
    private String moduleDesc;

    private String status;

    private boolean isActive;

    @CreationTimestamp
    private Timestamp createdDate;

    @CreatedBy
    private long createdBy;

    public ModuleMaster() {
    }

    public ModuleMaster(long moduleId, long comapnyId, String moduleDesc, String status, boolean isActive, Timestamp createdDate, long createdBy) {
        this.moduleId = moduleId;
        this.companyId = comapnyId;
        this.moduleDesc = moduleDesc;
        this.status = status;
        this.isActive = isActive;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
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
}
