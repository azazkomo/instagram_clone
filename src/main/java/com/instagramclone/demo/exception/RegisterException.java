package com.instagramclone.demo.exception;

public class RegisterException extends BaseException {
    public RegisterException(String code) {
        super("Register : " + code);
    }

    public static RegisterException registernull() {
        return new RegisterException("is Empty.");
    }

    public static RegisterException checkDataEmpty() {
        return new RegisterException("Data Is Empty.");
    }
}
