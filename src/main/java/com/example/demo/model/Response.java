package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Response implements Serializable {
    @Id
    private int respId;

    private int devId;

    private int feedId;

    private String answer;
    private LocalDate respDate;
    private int accuracy;

    public int getRespId() {
        return respId;
    }

    public void setRespId(int respId) {
        this.respId = respId;
    }

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public LocalDate getRespDate() {
        return respDate;
    }

    public void setRespDate(LocalDate respDate) {
        this.respDate = respDate;
    }



    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    @Override
    public String toString() {
        return "Response{" +
                "respId=" + respId +
                ", devId=" + devId +
                ", feedId=" + feedId +
                ", answer='" + answer + '\'' +
                ", respDate=" + respDate +
                ", accuracy=" + accuracy +
                '}';
    }
}

