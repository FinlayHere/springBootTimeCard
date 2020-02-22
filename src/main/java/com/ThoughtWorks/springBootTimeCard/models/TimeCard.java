package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;
@Entity
@Table(name = "time_card")
public class TimeCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("user")
    @Pattern(regexp = "[0-9]{5}", message = "User should be 5 numbers")
    private String userId;
    @JsonProperty("notes")
    @Length(min = 0, max = 100, message = "Notes should less than 100 characters")
    private String notes;
    @JsonProperty("timecard")
    @OneToMany(mappedBy = "timeCard")
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
