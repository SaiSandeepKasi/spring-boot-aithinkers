package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements coach{
    public TennisCoach() {
        System.out.println("In constructor :"+getClass().getSimpleName());
    }
    @Override
    public String getdailyWorkout() {
        return "Do your warmUp and practice tennis daily !!";
    }
}
