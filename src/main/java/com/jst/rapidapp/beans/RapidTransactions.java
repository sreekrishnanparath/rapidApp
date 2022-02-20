package com.jst.rapidapp.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jst.rapidapp.utils.commonConstants.JSONObjectConverter;
import com.jst.rapidapp.utils.commonConstants.JsonToMapConverter;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import netscape.javascript.JSObject;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@TypeDef(name = "json", typeClass = JsonType.class)
public class RapidTransactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long transId;

    private long companyId;

    private long moduleMasterId;
    @CreationTimestamp
    private Timestamp createdDate;
    private String status;
    @CreatedBy
    private long createdBy;

    @NotNull
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private Map<String, String> resultData = new HashMap<>();

    public Map<String, String> getResultData() {
        return resultData;
    }

    public RapidTransactions addResultData(String key, String value) {
        resultData.put(key, value);
        return this;
    }

    public void setResultData(Map<String, String> resultData) {
        this.resultData = resultData;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
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

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public RapidTransactions() {
    }

    public RapidTransactions(long transId, long companyId, long moduleMasterId, Timestamp createdDate, String status, long createdBy) {
        this.transId = transId;
        this.companyId = companyId;
        this.moduleMasterId = moduleMasterId;
        this.createdDate = createdDate;
        this.status = status;
        this.createdBy = createdBy;
    }
}
