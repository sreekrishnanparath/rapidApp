package com.jst.rapidapp.beans.configuration;

import javax.persistence.*;

@Entity
@Table(name="PARAMETERS")
public class Parameters {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="PARAMETER_ID")
    private long parameterId;

    @Column(name="VAT_REQ")
    private boolean vatRequired;

    @Column(name="VAT_PER")
    private double vatPercentage;


    public boolean isVatRequired() {
        return vatRequired;
    }

    public void setVatRequired(boolean vatRequired) {
        this.vatRequired = vatRequired;
    }

    public double getVatPercentage() {
        return vatPercentage;
    }

    public void setVatPercentage(double vatPercentage) {
        this.vatPercentage = vatPercentage;
    }
}
