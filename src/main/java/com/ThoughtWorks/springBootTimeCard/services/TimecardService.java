package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardDetailRepository;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author fanchaokong
 */
@Service
public class TimecardService {
    private TimecardRepository repository;
    private TimecardDetailRepository detailRepository;

    public TimecardService(TimecardRepository repository, TimecardDetailRepository detailRepository) {
        this.repository = repository;
        this.detailRepository = detailRepository;
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

    public void updateTimecard(Integer id, Timecard updateInfo) throws Exception {
        Timecard targetTimecard;
        if (repository.findById(id).isPresent()) {
             targetTimecard = repository.findById(id).get();
        }
        else {
            throw new Exception("Timecard not exist, please check timecard id");
        }

        if (Optional.ofNullable(updateInfo.getTimecardDetails()).isPresent()) {
            updateInfo.deleteNoIdTimecardDetail();
        }
        targetTimecard.adapt(updateInfo);

        repository.save(targetTimecard);
    }

    public void deleteTimecardDetailBy(int id) {
        detailRepository.deleteById(id);
    }

    public List findAllTimecards() {

        return repository.findAll();
    }

    public Timecard findTimeCardById(Integer id) {

        return repository.findById(id).get();
    }
}
