package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.models.TimeCardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimecardDetailRepository extends JpaRepository<TimeCardDetail, Integer> {

}
