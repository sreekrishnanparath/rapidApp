package com.jst.rapidapp.beans.configuration;

import com.jst.rapidapp.beans.Company;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationResponse {

    private String jwtToken;
    private UserDetails userDetails;
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public AuthenticationResponse(String jwtToken ,UserDetails userDetails, Company company) {
        this.jwtToken = jwtToken;
        this.userDetails = userDetails;
        this.company = company;
    }

    public AuthenticationResponse() {
    }
}
