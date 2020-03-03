package com.ThoughtWorks.springBootTimeCard.models;

import com.ThoughtWorks.springBootTimeCard.annotation.WorkTimeConstrain;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@Embeddable
@WorkTimeConstrain
public class WorkWeek {
    @JsonProperty(value = "Monday")
    @Column(name = "Monday")
    @Max(value = 8, message = "---ERROR---> Monday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Monday's Work should be positive")
    private Integer monday;
    @JsonProperty(value = "Tuesday")
    @Column(name = "Tuesday")
    @Max(value = 8, message = "---ERROR---> Tuesday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Tuesday's Work should be positive")
    private Integer tuesday;
    @JsonProperty(value = "Wednesday")
    @Column(name = "Wednesday")
    @Max(value = 8, message = "---ERROR---> Wednesday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Wednesday's Work should be positive")
    private Integer wednesday;
    @JsonProperty(value = "Thursday")
    @Column(name = "Thursday")
    @Max(value = 8, message = "---ERROR---> Thursday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Thursday's Work should be positive")
    private Integer thursday;
    @JsonProperty(value = "Friday")
    @Column(name = "Friday")
    @Max(value = 8, message = "---ERROR---> Friday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Friday's Work should be positive")
    private Integer friday;
    @JsonProperty(value = "Saturday")
    @Column(name = "Saturday")
    @Max(value = 8, message = "---ERROR---> Saturday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Saturday's Work should be positive")
    private Integer saturday;
    @JsonProperty(value = "Sunday")
    @Column(name = "Sunday")
    @Max(value = 8, message = "---ERROR---> Sunday's Work should less than 8 hours")
    @Min(value = 0,message = "---ERROR---> Sunday's Work should be positive")
    private Integer sunday;

    public WorkWeek() {
    }


    public WorkWeek(Integer monday, Integer tuesday, Integer wednesday, Integer thursday, Integer friday, Integer saturday, Integer sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public Integer getMonday() {
        return monday;
    }

    public void setMonday(Integer monday) {
        this.monday = monday;
    }

    public Integer getTuesday() {
        return tuesday;
    }

    public void setTuesday(Integer tuesday) {
        this.tuesday = tuesday;
    }

    public Integer getWednesday() {
        return wednesday;
    }

    public void setWednesday(Integer wednesday) {
        this.wednesday = wednesday;
    }

    public Integer getThursday() {
        return thursday;
    }

    public void setThursday(Integer thursday) {
        this.thursday = thursday;
    }

    public Integer getFriday() {
        return friday;
    }

    public void setFriday(Integer friday) {
        this.friday = friday;
    }

    public Integer getSaturday() {
        return saturday;
    }

    public void setSaturday(Integer saturday) {
        this.saturday = saturday;
    }

    public Integer getSunday() {
        return sunday;
    }

    public void setSunday(Integer sunday) {
        this.sunday = sunday;
    }

    public void adapt(WorkWeek workWeek) {
        if (Optional.ofNullable(workWeek.getMonday()).isPresent()) {
            this.setMonday(workWeek.getMonday());
        }
        if (Optional.ofNullable(workWeek.getTuesday()).isPresent()) {
            this.setTuesday(workWeek.getSunday());
        }
        if (Optional.ofNullable(workWeek.getWednesday()).isPresent()) {
            this.setWednesday(workWeek.getWednesday());
        }
        if (Optional.ofNullable(workWeek.getThursday()).isPresent()) {
            this.setThursday(workWeek.getThursday());
        }
        if (Optional.ofNullable(workWeek.getFriday()).isPresent()) {
            this.setFriday(workWeek.getFriday());
        }
        if (Optional.ofNullable(workWeek.getSaturday()).isPresent()) {
            this.setSaturday(workWeek.getSaturday());
        }
        if (Optional.ofNullable(workWeek.getSunday()).isPresent()) {
            this.setSunday(workWeek.getSunday());
        }
    }
}
