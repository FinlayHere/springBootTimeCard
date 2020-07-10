package com.ThoughtWorks.springBootTimeCard.featureToggle;

import org.togglz.core.Feature;
import org.togglz.core.annotation.EnabledByDefault;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum MyFeature implements Feature {

    @EnabledByDefault
    @Label("Non-pord")
    NON_PROD;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
