package com.ThoughtWorks.springBootTimeCard.models;

import java.util.Date;

public class TimeCardDetail {
    private Integer id;
    private String project;
    private String subProject;
    private String location;
    private Date startDate;
    private WorkWeek workWeek;
    private boolean billable;
    private String comments;
    private TimeCard timeCard;

    public TimeCardDetail() {
    }

    public TimeCardDetail(Integer id, String project, String subProject, String location, Date startDate, WorkWeek workWeek, boolean billable, String comments) {
        this.id = id;
        this.project = project;
        this.subProject = subProject;
        this.location = location;
        this.startDate = startDate;
        this.workWeek = workWeek;
        this.billable = billable;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSubProject() {
        return subProject;
    }

    public void setSubProject(String subProject) {
        this.subProject = subProject;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public WorkWeek getWorkWeek() {
        return workWeek;
    }

    public void setWorkWeek(WorkWeek workWeek) {
        this.workWeek = workWeek;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public TimeCard getTimeCard() {
        return timeCard;
    }

    public void setTimeCard(TimeCard timeCard) {
        this.timeCard = timeCard;
    }
}
