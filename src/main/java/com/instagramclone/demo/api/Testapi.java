package com.instagramclone.demo.api;
import com.instagramclone.demo.business.TestBusiness;
import com.instagramclone.demo.exception.BaseException;
import com.instagramclone.demo.model.MRegisterRequest;
import com.instagramclone.demo.model.MResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.instagramclone.demo.model.TestResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/test")
public class Testapi {

    //Dependency Injection
    //Method 1 => Field Injection
//    @Autowired
//    private TestBusiness business;

    //Method 2 Code ยาวกว่าแต่เร็วกว่า Method 1 => Constructor Injection
    private final TestBusiness business;

    public Testapi(TestBusiness business) {
        this.business = business;
    }


    @GetMapping
    public TestResponse test() {
        TestResponse response = new TestResponse();
        response.setName("test");
        response.setFood("test");
        return response;
    }

    @PostMapping
    @RequestMapping("/register")
    public ResponseEntity<Object> Register(@RequestBody MRegisterRequest request) {
        String response = null;
        MResponse responseData = new MResponse();
        try {
            response = business.register(request);
            return ResponseEntity.ok(response);
        } catch (BaseException e) {
            responseData.setStatus(false);
            responseData.setData(e.getMessage());
            return ResponseEntity.status(400).body(responseData);
        }
    }

    @PostMapping
    public ResponseEntity<Object> uploadProfilePicture(@RequestPart MultipartFile file) {
        MResponse responseData = new MResponse();
        try {
            String response = business.uploadProfilePicture(file);
            responseData.setStatus(true);
            responseData.setData(response);
            return ResponseEntity.status(200).body(responseData);
        } catch (BaseException e) {
            responseData.setStatus(false);
            responseData.setData(e.getMessage());
            return ResponseEntity.status(400).body(responseData);
        }
    }
}