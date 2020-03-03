package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.TimecardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimecardDetailRepository extends JpaRepository<TimecardDetail, Integer> {

}
