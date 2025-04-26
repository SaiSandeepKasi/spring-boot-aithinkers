package com.luv2code.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class cricketcoach implements coach{


    @Override
    public String getdailyWorkout() {
        return "run and bowl daily 15 times ";
    }
}
