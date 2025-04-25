package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class cricketcoach implements coach {

    public cricketcoach() {
        System.out.println("In constructor :"+getClass().getSimpleName());
    }

    @Override
    public String getdailyWorkout() {
        return "run and Do fast bowling daily 15 times -:)";
    }
}
