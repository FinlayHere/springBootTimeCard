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

    public List<Timecard> findTimecardDetailBySubProjectForm(List<Timecard> findingResultByProject, String subProject) {
        return findingResultByProject.stream()
                .filter(timecard -> timecard.onlyGetTimecardContainSpecificSubProject(subProject).getTimecardDetails().size() > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public void deleteBy(int id) {
        repository.deleteById(id);
    }
}
