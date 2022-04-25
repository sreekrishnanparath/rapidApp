package com.jst.rapidapp.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @OneToMany(targetEntity = ModuleAttributes.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "moduleId_fk",referencedColumnName = "moduleId")
    private List<ModuleAttributes> moduleAttributes;

}
