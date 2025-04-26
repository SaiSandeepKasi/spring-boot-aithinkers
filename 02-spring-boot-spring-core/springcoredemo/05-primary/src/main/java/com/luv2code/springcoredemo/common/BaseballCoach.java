package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements coach {
    @Override
    public String getdailyWorkout() {
        return "You need work on your back rally daily for 1 hour !!";
    }
}
