package com.example.demo.service;


import com.example.demo.exception.UnknownDeveloperException;
import com.example.demo.exception.UnknownFeedException;
import com.example.demo.model.Feed;
import com.example.demo.repositories.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Repository
public class FeedServiceImpl implements FeedService {

    @Autowired
    FeedRepository feedRepository;


    @Override
    public Feed addFeed(Feed feed) {
        // TODO Auto-generated method stub
        return feedRepository.save(feed);
    }

    @Override
    public Feed editFeed(Feed feed,int feedId) {
        // TODO Auto-generated method stub
        Feed rest = feedRepository.getById(feed.getFeedId());
        rest.setFeedId(feed.getFeedId());
        rest.setDevId(feed.getDevId());
        rest.setFeedDate(feed.getFeedDate());
        rest.setFeedTime(feed.getFeedTime());
        rest.setQuery(feed.getQuery());
        rest.setTopic(feed.getTopic());
        rest.setRelevance(feed.getRelevance());
        //rest.setResponses(rest.getResponses());
        rest.setTotalComments(feed.getTotalComments());

        return feedRepository.save(rest);
    }





    @Override
    public void removeFeed(int feedId) throws UnknownFeedException {
        // TODO Auto-generated method stub
       feedRepository.deleteById(feedId);
    }

    @Override
    public List<Feed> getFeedsByDeveloper(int devId) throws UnknownDeveloperException {
        // TODO Auto-generated method stub
        List<Feed> feeds = feedRepository.findAll();
        List<Feed> output = new ArrayList<>();
        for(Feed feed : feeds) {
            if(feed.getDevId() == devId) {
                output.add(feed);

            }
        }
        return output;
    }

    @Override
    public List<Feed> getFeedsByKeyword(String keyword) {
        // TODO Auto-generated method stub
        List<Feed> feeds = feedRepository.findAll();
        List<Feed> output = new ArrayList<>();
        for(Feed feed: feeds) {
            if(feed.getQuery()== keyword) {
                output.add(feed);
            }
        }
        return output;
    }

    @Override
    public List<Feed> getFeedsByTopic(String topic) {
        // TODO Auto-generated method stub
        List<Feed> feeds = feedRepository.findAll();
        List<Feed> output = new ArrayList<>();
        for(Feed feed : feeds) {
            if(feed.getTopic()== topic) {
                output.add(feed);
            }

        }
        return output;
    }

    @Override
    public List<Feed> fetchAll() {
        return feedRepository.findAll();
    }
}
