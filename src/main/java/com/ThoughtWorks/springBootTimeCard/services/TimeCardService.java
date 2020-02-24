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

    //TODO: 注释删掉
    /**
     * return the list of time card detail, by given user id
     * @param id  user id
     * @return list of time card detail, select by user id
     */

    public Collection<TimeCardDetail> searchTimeCardByUserId(String id) {

        //TODO: res啥意思啊
        List<TimeCardDetail> res = new ArrayList<>();

        List<Integer> timeCardIdList = new ArrayList<>();

        //TODO: 这里是在做什么？而且结果中有不需要的timeCard字段
        Collection<TimeCard> listOfTimeCard = timeCardRepository.findAllByUserId(id);
        listOfTimeCard.forEach(timeCard -> timeCard.setTimeCardDetails(null));
        listOfTimeCard.forEach(timeCard -> timeCardIdList.add(timeCard.getId()));

        //TODO: TC_Id命名规范？timecardId
        //TODO: java 8了解下？虽然这几行没啥用
        for (int TC_Id:timeCardIdList){
            for (TimeCardDetail tempTimeCardDetail:timecardDetailRepository.findByTimeCard_Id(TC_Id)){
                res.add(tempTimeCardDetail);
            }
        }
        return res;
    }
}
