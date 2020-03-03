package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimecardRepository extends JpaRepository<Timecard, Integer> {

    List<Timecard> findAllByUserId(String UserId);

    List<Timecard> findAllByTimecardDetailsProject(String project);
}
