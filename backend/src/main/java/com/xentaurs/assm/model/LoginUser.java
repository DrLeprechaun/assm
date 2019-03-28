package com.xentaurs.assm.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class LoginUser implements Serializable {

    private static final long serialVersionUID = -1764970284520387975L;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public LoginUser() {};

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
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
