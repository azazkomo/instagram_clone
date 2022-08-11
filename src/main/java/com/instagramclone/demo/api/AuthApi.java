package com.instagramclone.demo.api;

import com.instagramclone.demo.business.AuthAccount;
import com.instagramclone.demo.exception.BaseException;
import com.instagramclone.demo.model.AuthLogin;
import com.instagramclone.demo.model.MResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthApi {

    private final AuthAccount authprocess;

    public AuthApi(AuthAccount authprocess) {
        this.authprocess = authprocess;
    }

    @PostMapping("/login")
    public ResponseEntity<MResponse> postLogin(@RequestBody AuthLogin request) {
        MResponse response = new MResponse();
        try {
            response = authprocess.CheckLogin(request);
            return ResponseEntity.ok(response);
        } catch (BaseException e) {
            response.setStatus(false);
            response.setData(e.getMessage());
            return ResponseEntity.status(200).body(response);
        }
    }
}
