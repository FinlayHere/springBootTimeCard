package com.ThoughtWorks.springBootTimeCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.togglz.core.context.StaticFeatureManagerProvider;
import org.togglz.core.manager.FeatureManager;

@SpringBootApplication
public class SpringBootTimeCardApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTimeCardApplication.class, args);

        FeatureManager featureManager = context.getBean(FeatureManager.class);
        StaticFeatureManagerProvider.setFeatureManager(featureManager);
    }

}

