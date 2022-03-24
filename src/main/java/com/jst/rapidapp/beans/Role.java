package com.jst.rapidapp.beans;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="ROLE_MASTER")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="ROLE_ID")
    private long roleId;

    @Column(name="ROLE_DESC")
    private String roleDesc;

    @CreatedBy
    @Column(name="CREATED_BY")
    private String createdBy;

    @CreationTimestamp
    @Column(name="CREATED_DT")
    private Date createdDt;

    @Column(name="STATUS")
    private String status;

    @LastModifiedBy
    @Column(name="STATUS_BY")
    private String statusBy;

    @LastModifiedDate
    @Column(name="STATUS_DT")
    private String statusDt;

    @Column(name="ACTIVE")
    private boolean active;

    @Column(name="ALLOW_NEW")
    private boolean allowNew;

    @Column(name="ALLOW_EDIT")
    private boolean allowEdit;

    @Column(name="ALLOW_VIEW")
    private boolean allowView;

    @Column(name="ALLOW_DELETE")
    private boolean allowDelete;

    @Column(name="ALLOW_AUTH")
    private boolean allowAuthorize;


    public boolean isAllowNew() {
        return allowNew;
    }

    public void setAllowNew(boolean allowNew) {
        this.allowNew = allowNew;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowView() {
        return allowView;
    }

    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isAllowAuthorize() {
        return allowAuthorize;
    }

    public void setAllowAuthorize(boolean allowAuthorize) {
        this.allowAuthorize = allowAuthorize;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusBy() {
        return statusBy;
    }

    public void setStatusBy(String statusBy) {
        this.statusBy = statusBy;
    }

    public String getStatusDt() {
        return statusDt;
    }

    public void setStatusDt(String statusDt) {
        this.statusDt = statusDt;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleDesc='" + roleDesc + '\'' +
                ", createdBy='" + createdBy + '\'' +
                ", createdDt=" + createdDt +
                ", status='" + status + '\'' +
                ", statusBy='" + statusBy + '\'' +
                ", statusDt='" + statusDt + '\'' +
                ", active=" + active +
                '}';
    }


}

