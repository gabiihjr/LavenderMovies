package com.api.lavendermovies.forms;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class JwtRequestForm implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

    public JwtRequestForm(String token)
    {

    }

    public JwtRequestForm(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
