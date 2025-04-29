package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TennisCoach implements coach{
    @Override
    public String getdailyWorkout() {
        return "Do your warmUp and practice tennis daily !!";
    }
}
