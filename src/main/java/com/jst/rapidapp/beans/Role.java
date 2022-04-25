package com.jst.rapidapp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Data
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




}

