package com.ThoughtWorks.springBootTimeCard.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Entity
@Table(name = "time_card")
public class Timecard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id")
    private Integer id;
    @JsonProperty("user")
    @Column(name = "user_id")
    @Pattern(regexp = "[0-9]{5}", message = "---ERROR--->User should be 5 numbers")
    private String userId;
    @JsonProperty("notes")
    @Column(name = "notes")
    @Length(max = 100, message = "---ERROR--->Notes should less than 100 characters")
    private String notes;
    @JsonProperty("timecard")
    @OneToMany(mappedBy = "timecard", cascade = CascadeType.PERSIST)
    @Valid
    private List<TimecardDetail> timecardDetails;

    public void addForeignKeyToTimeCardDetail(){
        this.timecardDetails.forEach(cardDetail->{cardDetail.setTimecard(this);});
    }

    public Timecard() {
    }

    public Timecard(Integer id, String userId, String notes, List<TimecardDetail> timecardDetails) {
        this.id = id;
        this.userId = userId;
        this.notes = notes;
        this.timecardDetails = timecardDetails;
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

    public List<TimecardDetail> getTimecardDetails() {
        return timecardDetails;
    }

    public void setTimecardDetails(List<TimecardDetail> timecardDetails) {
        this.timecardDetails = timecardDetails;
    }

    public Timecard onlyGetTimecardContainSpecificSubProject(String subProject) {
        List<TimecardDetail> timecardDetailsContainSpecificSubProject = this.getTimecardDetails().stream()
                .filter(timecardDetail -> timecardDetail.getSubProject().equals(subProject))
                .collect(Collectors.toCollection(ArrayList::new));

        this.setTimecardDetails(timecardDetailsContainSpecificSubProject);

        return this;
    }

    public void deleteNoIdTimecardDetail() {
        this.setTimecardDetails(this.getTimecardDetails().stream()
                                                         .filter(timecardDetail -> timecardDetail.getId() != null)
                                                         .collect(Collectors.toCollection(ArrayList::new)));
    }

    public TimecardDetail findTimecardDetailById(int id) throws Exception {
        for (TimecardDetail detail : this.getTimecardDetails()) {
            if (detail.getId() == id) {
                return detail;
            }
        }
        throw new Exception("Timecard Detail Id No match");
    }


    public void adapt(Timecard updateInfo) throws Exception {
        if (Optional.ofNullable(updateInfo.getUserId()).isPresent()) {
            this.setUserId(updateInfo.getUserId());
        }
        if (Optional.ofNullable(updateInfo.getNotes()).isPresent()) {
            this.setNotes(updateInfo.getNotes());
        }
        if (Optional.ofNullable(updateInfo.getTimecardDetails()).isPresent()) {
            for (TimecardDetail detail : updateInfo.getTimecardDetails()){
                TimecardDetail targetTimecardDetail = this.findTimecardDetailById(detail.getId());
                targetTimecardDetail.adapt(detail);
            }
        }
    }
}
