package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardRepository;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimecardService {
    //TODO: 命名 repository
    private TimecardRepository timecardRepository;
    //TODO: 引了没用
    private TimecardDetailRepository timecardDetailRepository;

    public TimecardService(TimecardRepository timeCardRepository, TimecardDetailRepository timecardDetailRepository) {
        this.timecardRepository = timeCardRepository;
        this.timecardDetailRepository = timecardDetailRepository;
    }

    public String addTimeCard(Timecard timeCard) {
        timeCard.addForeignKeyToTimeCardDetail();
        timecardRepository.save(timeCard);
        //TODO: 这个created返回值是什么?
        return "Created";
    }

    public List<Timecard> findTimecardByUserId(String userId) {
        return timecardRepository.findAllByUserId(userId);
    }

    public List<Timecard> findTimecardByProject(String projectName) {
        return timecardRepository.findAllByTimecardDetailsProject(projectName);
    }
}
