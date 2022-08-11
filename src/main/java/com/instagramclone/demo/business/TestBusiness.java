package com.instagramclone.demo.business;

import com.instagramclone.demo.model.MRegisterRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;

@Service
public class TestBusiness {

    public String register(MRegisterRequest request) throws IOException {
        if(request == null) {
            throw new IOException("Request Null");
        }

        if(Objects.isNull(request.getEmail())) {
            throw new IOException("Email Null");
        }
        return "" + request.getEmail();
    }
}
