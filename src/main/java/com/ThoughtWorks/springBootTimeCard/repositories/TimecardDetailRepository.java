package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.TimecardDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimecardDetailRepository extends JpaRepository<TimecardDetail, Integer> {

}
