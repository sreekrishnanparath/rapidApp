package com.jst.rapidapp.beans;


import javax.persistence.*;

@Entity
@Table(name="lookup_master")
public class LookupMaster {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long lookId;

    private long companyId;


    @Column(name="look_ref_id")
    private String lookRefId ;

    private String lookDesc;

    private String status;

    private boolean isActive;

    public LookupMaster() {
    }

    public LookupMaster(long lookId, long companyId, String lookRefId, String lookDesc, String status, boolean isActive) {
        this.lookId = lookId;
        this.companyId = companyId;
        this.lookRefId = lookRefId;
        this.lookDesc = lookDesc;
        this.status = status;
        this.isActive = isActive;
    }

    public long getLookId() {
        return lookId;
    }

    public void setLookId(long lookId) {
        this.lookId = lookId;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getLookRefId() {
        return lookRefId;
    }

    public void setLookRefId(String lookRefId) {
        this.lookRefId = lookRefId;
    }

    public String getLookDesc() {
        return lookDesc;
    }

    public void setLookDesc(String lookDesc) {
        this.lookDesc = lookDesc;
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
}
