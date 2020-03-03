package com.ThoughtWorks.springBootTimeCard.validator;

import com.ThoughtWorks.springBootTimeCard.annotation.WorkTimeConstrain;
import com.ThoughtWorks.springBootTimeCard.models.WorkWeek;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkTimeConstrainValidator implements ConstraintValidator<WorkTimeConstrain, WorkWeek> {

    @Override
    public void initialize(WorkTimeConstrain constraintAnnotation) {

    }

    @Override
    public boolean isValid(WorkWeek workWeek, ConstraintValidatorContext context) {
        int totalHoursOfWeek;

        totalHoursOfWeek = workWeek.getMonday() + workWeek.getTuesday() + workWeek.getWednesday()
                + workWeek.getThursday() + workWeek.getFriday() + workWeek.getSaturday() + workWeek.getSunday();

        return totalHoursOfWeek < 57 && totalHoursOfWeek > 39;
    }
}
