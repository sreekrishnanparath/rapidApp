package com.jst.rapidapp.beans;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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


    public Company() {
    }

    public Company(long companyId, String companyName, String companyUser, String status, boolean isActive) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyUser = companyUser;
        this.status = status;
        this.isActive = isActive;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
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
