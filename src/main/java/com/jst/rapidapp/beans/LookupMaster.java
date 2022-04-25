package com.jst.rapidapp.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Data
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



}
