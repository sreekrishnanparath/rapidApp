package com.jst.rapidapp.beans;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jst.rapidapp.utils.JSONObjectConverter;
import com.jst.rapidapp.utils.JsonToMapConverter;
import com.sun.istack.NotNull;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
