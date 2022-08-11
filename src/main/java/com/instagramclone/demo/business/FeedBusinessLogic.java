package com.instagramclone.demo.business;


import com.instagramclone.demo.model.MFeed;
import com.instagramclone.demo.model.MResponseList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class FeedBusinessLogic {

    public MResponseList GetFeedAll() {
        MResponseList responseList = new MResponseList();
        MFeed FeedModal = new MFeed();
        List<MFeed> feedList = new ArrayList<>();

        for(int i = 0; i < 20; i++) {
            FeedModal.setName("Jessica Park " + i);
            FeedModal.setMessage("That's hilarious, really");
            FeedModal.setImage("https://picsum.photos/700");
            FeedModal.setTime("19.24");
            feedList.add(FeedModal);
            FeedModal = new MFeed();
        }

        responseList.setStatus(true);
        responseList.setData(feedList);

        return responseList;
    }

}
