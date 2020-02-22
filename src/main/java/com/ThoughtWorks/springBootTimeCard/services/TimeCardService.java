package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.repositories.TimeCardRepository;
import org.springframework.stereotype.Service;

@Service
public class TimeCardService {

    private TimeCardRepository repository;

    public TimeCardService(TimeCardRepository repository) {
        this.repository = repository;
    }

    public String addTimeCard(TimeCard timeCard) {
        timeCard.addForeignKeyToTimeCardDetail();
        repository.save(timeCard);
        return "Created";
    }
}
