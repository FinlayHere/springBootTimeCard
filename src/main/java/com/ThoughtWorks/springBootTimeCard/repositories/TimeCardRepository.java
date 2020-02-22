package com.ThoughtWorks.springBootTimeCard.repositories;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TimeCardRepository extends JpaRepository<TimeCard, Integer> {
//    @Query("SELECT t FROM TIMECARD t WHERE t.user_id = ?1")
    Collection<TimeCard> findAllByUserId(String userId);
}
