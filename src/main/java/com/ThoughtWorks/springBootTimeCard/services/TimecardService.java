package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardRepository;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimecardService {
    private TimecardRepository timecardRepository;
    private TimecardDetailRepository timecardDetailRepository;

    public TimecardService(TimecardRepository timeCardRepository, TimecardDetailRepository timecardDetailRepository) {
        this.timecardRepository = timeCardRepository;
        this.timecardDetailRepository = timecardDetailRepository;
    }

    public String addTimeCard(Timecard timeCard) {
        timeCard.addForeignKeyToTimeCardDetail();
        timecardRepository.save(timeCard);
        return "Created";
    }

    public List<Timecard> findTimecardByUserId(String userId) {
        return timecardRepository.findAllByUserId(userId);
    }

    public List<Timecard> findTimecardByProject(String projectName) {
        return timecardRepository.findAllByTimecardDetails_project(projectName);
    }
}
