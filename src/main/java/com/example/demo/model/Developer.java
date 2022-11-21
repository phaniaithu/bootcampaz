package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Developer implements Serializable {
    @Id

    private int devId;
    private String devname;
    private String email;
    private String skillLevel;	// Beginner/Intermediate/Expert
    private LocalDate memberSince;

    private int totalFeeds;
    private int reputation;// Likes on Feed/Response by developer increase reputation



    public Developer() {
    }

    public Developer(int devId, String devname, String email, String skillLevel, LocalDate memberSince, int totalFeeds, int reputation) {
        super();
        this.devId = devId;
        this.devname = devname;
        this.email = email;
        this.skillLevel = skillLevel;
        this.memberSince = memberSince;
        this.totalFeeds = totalFeeds;
        this.reputation = reputation;
    }

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


    @Override
    public String toString() {
        return "Developer{" +
                "devId=" + devId +
                ", name='" + devname + '\'' +
                ", email='" + email + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                ", memberSince=" + memberSince +
                ", totalFeeds=" + totalFeeds +
                ", reputation=" + reputation +
                '}';
    }
}


