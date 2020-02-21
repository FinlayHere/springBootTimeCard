package com.ThoughtWorks.springBootTimeCard.models;

import java.util.List;

public class TimeCard {
    private Integer id;
    private String userId;
    private String notes;
    private List<TimeCardDetail> timeCardDetails;

    public TimeCard() {
    }

    public TimeCard(Integer id, String userId, String notes, List<TimeCardDetail> timeCardDetails) {
        this.id = id;
        this.userId = userId;
        this.notes = notes;
        this.timeCardDetails = timeCardDetails;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<TimeCardDetail> getTimeCardDetails() {
        return timeCardDetails;
    }

    public void setTimeCardDetails(List<TimeCardDetail> timeCardDetails) {
        this.timeCardDetails = timeCardDetails;
    }
}
