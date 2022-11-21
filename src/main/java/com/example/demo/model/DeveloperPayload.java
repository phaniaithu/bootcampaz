package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class DeveloperPayload {
    @JsonProperty("devId")
    private int devId;
    @JsonProperty("devname")
    private String devname;
    @JsonProperty("email")
    private String email;
    @JsonProperty("skilllevel")
    private String skillLevel;
    @JsonProperty("memberSince")
    private LocalDate memberSince;
    @JsonProperty("totalFeeds")
    private int totalFeeds;

    @JsonProperty("reputation")
    private int reputation;

    public int getDevId() {
        return devId;
    }

    public void setDevId(int devId) {
        this.devId = devId;
    }

    public String getDevname() {
        return devname;
    }

    public void setDevname(String devname) {
        this.devname = devname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public int getTotalFeeds() {
        return totalFeeds;
    }

    public void setTotalFeeds(int totalFeeds) {
        this.totalFeeds = totalFeeds;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }




}
