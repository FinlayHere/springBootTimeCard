package com.ThoughtWorks.springBootTimeCard.repositories;

//TODO: 没用的import删掉
import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.models.TimeCardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface TimecardDetailRepository extends JpaRepository<TimeCardDetail, Integer> {

    //TODO: 为啥定义了Collection，List不是可以直接用吗？
    //TODO: 命名规范：没有下划线
    Collection<TimeCardDetail> findByTimeCard_Id(int timeCardId);

    //TODO: 注释删掉
//    Collection<TimeCardDetail> findAllByTimeCard_id(List<Integer> timeCardIdList);
}
