package com.ThoughtWorks.springBootTimeCard.models;

public class WorkWeek {
    private Integer Monday;
    private Integer Tuesday;
    private Integer Wednesday;
    private Integer Thursday;
    private Integer Friday;
    private Integer Saturday;
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
