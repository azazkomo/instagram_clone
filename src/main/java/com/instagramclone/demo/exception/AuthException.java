package com.instagramclone.demo.exception;

import jdk.jshell.spi.ExecutionControl;

public class AuthException extends BaseException {

    public AuthException(String code) {
        super("Auth : " + code);
    }

    public static AuthException LoginRequestEmpty() {
        return new AuthException("Request is Empty.");
    }

    public static AuthException ObjectEmpty() {
        return new AuthException("Username or Password is Empty.");
    }

}
