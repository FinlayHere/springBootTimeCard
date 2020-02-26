package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimecardService {
    private TimecardRepository repository;

    public TimecardService(TimecardRepository repository) {
        this.repository = repository;
    }

    public void addTimeCard(Timecard timeCard) {
        timeCard.addForeignKeyToTimeCardDetail();
        repository.save(timeCard);
    }

    public List<Timecard> findTimecardByUserId(String userId) {
        return repository.findAllByUserId(userId);
    }

    public List<Timecard> findTimecardByProject(String projectName) {
        return repository.findAllByTimecardDetailsProject(projectName);
    }

    //TODO: 这个方法命名不好
    public List<Timecard> findSubProjectFromFindingByProjectResult(List<Timecard> findingResultByProject, String subProject) {
        return findingResultByProject.stream()
                //TODO: > 前后都有空格
                .filter(timecard -> timecard.onlyGetTimecardContainSpecificSubProject(subProject).getTimecardDetails().size()>0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //TODO: 这个方法命名不好，可以简单叫delete(int id)或者deleteBy(int id)
    public void deleteTimecardByItsId(int id) {
        repository.deleteById(id);
    }
}
