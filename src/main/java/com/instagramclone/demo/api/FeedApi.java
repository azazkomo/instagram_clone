package com.instagramclone.demo.api;

import com.instagramclone.demo.business.FeedBusinessLogic;
import com.instagramclone.demo.model.MResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feed")
public class FeedApi {


    private final FeedBusinessLogic feedbus;

    public FeedApi(FeedBusinessLogic feedbus) {
        this.feedbus = feedbus;
    }

    @GetMapping
    public ResponseEntity<MResponseList> GetFeedList() {
        MResponseList responseList = new MResponseList();
        responseList = feedbus.GetFeedAll();
        return ResponseEntity.status(200).body(responseList);
    }

}
