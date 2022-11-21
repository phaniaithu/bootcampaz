package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Feed implements Serializable {
    @Id
    private int feedId;
    private String query;
    private LocalDate feedDate;
    private LocalTime feedTime;
    private String topic;	// Programming/Java/Testing
    private int relevance;	// Likes on Feed increase relevance
    private int devId;
    //private List<Response> responses;
    private int totalComments;

    public Feed() {
    }

    public Feed(int feedId, String query, LocalDate feedDate, LocalTime feedTime, String topic, int relevance, List<Response> responses, int totalComments) {
        super();
        this.feedId = feedId;
        this.query = query;
        this.feedDate = feedDate;
        this.feedTime = feedTime;
        this.topic = topic;
        this.relevance = relevance;
        //this.dev = dev;
        //this.responses = responses;
        this.totalComments = totalComments;
    }
    public int getFeedId() {
        return feedId;
    }
    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
    public LocalDate getFeedDate() {
        return feedDate;
    }
    public void setFeedDate(LocalDate feedDate) {
        this.feedDate = feedDate;
    }
    public LocalTime getFeedTime() {
        return feedTime;
    }
    public void setFeedTime(LocalTime feedTime) {
        this.feedTime = feedTime;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public int getRelevance() {
        return relevance;
    }
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }



    public int getTotalComments() {
        return totalComments;
    }
    public void setTotalComments(int totalComments) {
        this.totalComments = totalComments;
    }

    @Override
    public String toString() {
        return "Feed{" +
                "feedId=" + feedId +
                ", query='" + query + '\'' +
                ", feedDate=" + feedDate +
                ", feedTime=" + feedTime +
                ", topic='" + topic + '\'' +
                ", relevance=" + relevance +
                ", devId=" + devId +
                ", totalComments=" + totalComments +
                '}';
    }
}