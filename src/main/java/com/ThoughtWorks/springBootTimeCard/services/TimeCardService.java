package com.ThoughtWorks.springBootTimeCard.services;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.models.TimeCardDetail;
import com.ThoughtWorks.springBootTimeCard.repositories.TimeCardRepository;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardDetailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TimeCardService {

    private TimeCardRepository timeCardRepository;
    private TimecardDetailRepository timecardDetailRepository;

    public TimeCardService(TimeCardRepository timeCardRepository, TimecardDetailRepository timecardDetailRepository) {
        this.timeCardRepository = timeCardRepository;
        this.timecardDetailRepository = timecardDetailRepository;
    }

    public String addTimeCard(TimeCard timeCard) {
        timeCard.addForeignKeyToTimeCardDetail();
        timeCardRepository.save(timeCard);
        return "Created";
    }

    /**
     * return the list of time card detail, by given user id
     * @param id  user id
     * @return list of time card detail, select by user id
     */

    public Collection<TimeCardDetail> searchTimeCardByUserId(String id) {

        List<TimeCardDetail> res = new ArrayList<>();

        List<Integer> timeCardIdList = new ArrayList<>();

        Collection<TimeCard> listOfTimeCard = timeCardRepository.findAllByUserId(id);
        listOfTimeCard.forEach(timeCard -> timeCard.setTimeCardDetails(null));
        listOfTimeCard.forEach(timeCard -> timeCardIdList.add(timeCard.getId()));

        for (int TC_Id:timeCardIdList){
            for (TimeCardDetail tempTimeCardDetail:timecardDetailRepository.findByTimeCard_Id(TC_Id)){
                res.add(tempTimeCardDetail);
            }
        }
        return res;
    }
}
