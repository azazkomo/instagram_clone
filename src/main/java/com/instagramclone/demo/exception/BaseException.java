package com.instagramclone.demo.exception;

public abstract class BaseException extends Exception {

    public BaseException(String code) {
        super(code);
    }
}
