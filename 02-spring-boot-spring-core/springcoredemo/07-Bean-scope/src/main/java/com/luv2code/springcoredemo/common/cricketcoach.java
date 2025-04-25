package com.luv2code.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class cricketcoach implements coach {

    public cricketcoach() {
        System.out.println("In constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getdailyWorkout() {
        return "run and Do fast bowling daily 15 times -:)";
    }
}
