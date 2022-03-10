package com.jst.rapidapp.beans.configuration;

import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationResponse {

    private String jwtToken;
    private UserDetails userDetails;

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

    public AuthenticationResponse(String jwtToken ,UserDetails userDetails) {
        this.jwtToken = jwtToken;
        this.userDetails = userDetails;
    }

    public AuthenticationResponse() {
    }
}
