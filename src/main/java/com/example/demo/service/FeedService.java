package com.example.demo.service;

import com.example.demo.exception.UnknownDeveloperException;
import com.example.demo.exception.UnknownFeedException;
import com.example.demo.model.Feed;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Repository
public interface FeedService {
    Feed addFeed(Feed feed);

    Feed editFeed(Feed feed, int feedId);





    void removeFeed(int feedId) throws UnknownFeedException;

    List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException;

    List<Feed> getFeedsByKeyword(String keyword);

    List<Feed> getFeedsByTopic(String topic);

    List<Feed> fetchAll();
}
