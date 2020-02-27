package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.TimecardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fanchaokong
 */
@Repository
public interface TimecardDetailRepository extends JpaRepository<TimecardDetail, Integer> {

}
