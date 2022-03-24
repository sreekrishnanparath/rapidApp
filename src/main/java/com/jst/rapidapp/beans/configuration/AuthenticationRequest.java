package com.jst.rapidapp.beans.configuration;

public class AuthenticationRequest {

    private String username;
    private String password;

    public AuthenticationRequest(String userName, String passWord) {
        this.username = userName;
        this.password = passWord;
    }

    public AuthenticationRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
