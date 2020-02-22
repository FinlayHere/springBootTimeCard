package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class WorkWeek {
    @JsonProperty(value = "Monday")
    @Column(name = "Monday")
    @Size(min = 0,max = 8, message = "Monday's work hours should between 0 and 8")
    private Integer Monday;
    @JsonProperty(value = "Tuesday")
    @Column(name = "Tuesday")
    @Size(min = 0,max = 8, message = "Tuesday's work hours should between 0 and 8")
    private Integer Tuesday;
    @JsonProperty(value = "Wednesday")
    @Column(name = "Wednesday")
    @Size(min = 0,max = 8, message = "Wednesday's work hours should between 0 and 8")
    private Integer Wednesday;
    @JsonProperty(value = "Thursday")
    @Column(name = "Thursday")
    @Size(min = 0,max = 8, message = "Thursday's work hours should between 0 and 8")
    private Integer Thursday;
    @JsonProperty(value = "Friday")
    @Column(name = "Friday")
    @Size(min = 0,max = 8, message = "Friday's work hours should between 0 and 8")
    private Integer Friday;
    @JsonProperty(value = "Saturday")
    @Column(name = "Saturday")
    @Size(min = 0,max = 8, message = "Saturday's work hours should between 0 and 8")
    private Integer Saturday;
    @JsonProperty(value = "Sunday")
    @Column(name = "Sunday")
    @Size(min = 0,max = 8, message = "Sunday's work hours should between 0 and 8")
    private Integer Sunday;

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
