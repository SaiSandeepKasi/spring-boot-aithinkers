package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component

public class BaseballCoach implements coach {
    public BaseballCoach() {
        System.out.println("In constructor :"+getClass().getSimpleName());
    }
    @Override
    public String getdailyWorkout() {
        return "You need work on your back rally daily for 1 hour !!";
    }
}
