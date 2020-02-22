package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Embeddable
public class WorkWeek {
    @JsonProperty(value = "Monday")
    @Column(name = "Monday")
    @Max(value = 8, message = "---EEROR--- \nMonday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nMonday's Work should be positive")
    private Integer Monday;
    @JsonProperty(value = "Tuesday")
    @Column(name = "Tuesday")
    @Max(value = 8, message = "---EEROR--- \nTuesday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nTuesday's Work should be positive")
    private Integer Tuesday;
    @JsonProperty(value = "Wednesday")
    @Column(name = "Wednesday")
    @Max(value = 8, message = "---EEROR--- \nWednesday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nWednesday's Work should be positive")
    private Integer Wednesday;
    @JsonProperty(value = "Thursday")
    @Column(name = "Thursday")
    @Max(value = 8, message = "---EEROR--- \nThursday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nThursday's Work should be positive")
    private Integer Thursday;
    @JsonProperty(value = "Friday")
    @Column(name = "Friday")
    @Max(value = 8, message = "---EEROR--- \nFriday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nFriday's Work should be positive")
    private Integer Friday;
    @JsonProperty(value = "Saturday")
    @Column(name = "Saturday")
    @Max(value = 8, message = "---EEROR--- \nSaturday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nSaturday's Work should be positive")
    private Integer Saturday;
    @JsonProperty(value = "Sunday")
    @Column(name = "Sunday")
    @Max(value = 8, message = "---EEROR--- \nSunday's Work should less than 8 hours")
    @Min(value = 0,message = "---EEROR--- \nSunday's Work should be positive")
    private int Sunday;

    public WorkWeek() {
    }

    public WorkWeek(Integer monday, Integer tuesday, Integer wednesday, Integer thursday, Integer friday, Integer saturday, Integer sunday) {
        Monday = monday;
        Tuesday = tuesday;
        Wednesday = wednesday;
        Thursday = thursday;
        Friday = friday;
        Saturday = saturday;
        Sunday = sunday;
    }

    public Integer getMonday() {
        return Monday;
    }

    public void setMonday(Integer monday) {
        Monday = monday;
    }

    public Integer getTuesday() {
        return Tuesday;
    }

    public void setTuesday(Integer tuesday) {
        Tuesday = tuesday;
    }

    public Integer getWednesday() {
        return Wednesday;
    }

    public void setWednesday(Integer wednesday) {
        Wednesday = wednesday;
    }

    public Integer getThursday() {
        return Thursday;
    }

    public void setThursday(Integer thursday) {
        Thursday = thursday;
    }

    public Integer getFriday() {
        return Friday;
    }

    public void setFriday(Integer friday) {
        Friday = friday;
    }

    public Integer getSaturday() {
        return Saturday;
    }

    public void setSaturday(Integer saturday) {
        Saturday = saturday;
    }

    public Integer getSunday() {
        return Sunday;
    }

    public void setSunday(Integer sunday) {
        Sunday = sunday;
    }
}
