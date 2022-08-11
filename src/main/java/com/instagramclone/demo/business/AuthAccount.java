package com.instagramclone.demo.business;

import com.instagramclone.demo.exception.AuthException;
import com.instagramclone.demo.exception.BaseException;
import com.instagramclone.demo.model.AuthLogin;
import com.instagramclone.demo.model.MResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthAccount {

    public MResponse CheckLogin(AuthLogin LoginData) throws BaseException {

        MResponse response = new MResponse();

        if(LoginData == null) {
            throw AuthException.LoginRequestEmpty();
        }

        if(Objects.isNull(LoginData.getUsername()) || Objects.isNull(LoginData.getPassword())) {
            throw AuthException.LoginRequestEmpty();
        }

        if(LoginData.getUsername().equals("") || LoginData.getUsername() == null || LoginData.getPassword().equals("") || LoginData.getPassword() == null) {
            response.setStatus(false);
            response.setData("Username or Password is Empty.");
        } else if(LoginData.getUsername().equals("admin") && LoginData.getPassword().equals("1234")) {
            response.setStatus(true);
            response.setData("Login Success");
        } else {
            response.setStatus(false);
            response.setData("Login Failed");
        }
        return response;
    }
}
