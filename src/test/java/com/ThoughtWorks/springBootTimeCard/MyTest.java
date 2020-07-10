package com.ThoughtWorks.springBootTimeCard;

import com.ThoughtWorks.springBootTimeCard.featureToggle.MyFeature;
import org.junit.jupiter.api.Test;

public class MyTest {
    @Test
    void test(){
        System.out.println(MyFeature.NON_PROD.isActive());
    }
}
