package com.ThoughtWorks.springBootTimeCard.config;

import com.ThoughtWorks.springBootTimeCard.featureToggle.MyTogglzConfiguration;
import org.springframework.context.annotation.Bean;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;

public class ApplicationContext {
    @Bean
    public FeatureManager getFeatureManager(){
        return new FeatureManagerBuilder().togglzConfig(new MyTogglzConfiguration()).build();
    }
}
