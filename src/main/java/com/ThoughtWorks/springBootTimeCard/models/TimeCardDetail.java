package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "timecard_detail")
public class TimeCardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer id;
    @Column(name = "project")
    @NotBlank(message = "Project should not be blank")
    private String project;
    @JsonProperty("sub-project")
    @Column(name = "sub_project")
    @NotBlank(message = "Sub-Project should not be blank")
    private String subProject;
    @JsonProperty("location")
    @Column(name = "location")
    @NotBlank(message = "Location should not be blank")
    private String location;
    @JsonProperty("startDate")
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Embedded
    @Valid
    @JsonProperty(value = "timecards")
    private WorkWeek workWeek;
    @JsonProperty("billable")
    @Column(name = "billable")
    @NotBlank(message = "Billable should not be blank")
    private boolean billable;
    @JsonProperty("comments")
    @Column(name = "comments")
    @Length(max = 100, message = "Comments should not more than 100 characters")
    private String comments;
    private TimeCard timeCard;

    public TimeCardDetail() {
    }

    public TimeCardDetail(Integer id, String project, String subProject, String location, Date startDate,
                          WorkWeek workWeek, boolean billable, String comments) {
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
