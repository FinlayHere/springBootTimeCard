package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "timecard_detail")
public class TimecardDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer id;
    @Column(name = "project")
    @NotBlank(message = "---ERROR---> Project should not be blank")
    private String project;
    @JsonProperty("sub-project")
    @Column(name = "sub_project")
    @NotBlank(message = "---ERROR---> Sub-Project should not be blank")
    private String subProject;
    @JsonProperty("location")
    @Column(name = "location")
    @NotBlank(message = "---ERROR---> Location should not be blank")
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
    @NotNull(message = "---ERROR---> Billable should not be blank")
    private boolean billable;
    @JsonProperty("comments")
    @Column(name = "comments")
    @Length(max = 100, message = "---ERROR---> Comments should not more than 100 characters")
    private String comments;
    @ManyToOne
    @JoinColumn(name = "card_id", nullable = false)
    @JsonIgnore
    private Timecard timecard;

    public TimecardDetail() {
    }

    public TimecardDetail(Integer id,String project, String subProject, String location, Date startDate, WorkWeek workWeek, boolean billable, String comments, Timecard timecard) {
        this.id = id;
        this.project = project;
        this.subProject = subProject;
        this.location = location;
        this.startDate = startDate;
        this.workWeek = workWeek;
        this.billable = billable;
        this.comments = comments;
        this.timecard = timecard;
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

    public Timecard getTimecard() {
        return timecard;
    }

    public void setTimecard(Timecard timecard) {
        this.timecard = timecard;
    }
}
