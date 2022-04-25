package com.jst.rapidapp.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private long companyId;

    @NotEmpty(message = "Company Name is required")
    private String companyName;

    @NotEmpty(message = "User name is required")
    private String companyUser;

    private String status;

    private boolean isActive;

    @OneToMany(targetEntity = User.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId_fk",referencedColumnName = "companyId")
    private List<User> users;

    @OneToMany(targetEntity = ModuleMaster.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId_fk",referencedColumnName = "companyId")
    private List<ModuleMaster> modulesMaster;

    @OneToMany(targetEntity = ModuleAttributes.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId_fk",referencedColumnName = "companyId")
    private List<ModuleAttributes> moduleAttributes;





}
