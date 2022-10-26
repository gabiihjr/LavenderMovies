package com.api.lavendermovies.config.exceptions;

public class RequiredFieldException extends BusinessException{

    public RequiredFieldException(String field) {
        super("Field %s is required", field);
    }
}
