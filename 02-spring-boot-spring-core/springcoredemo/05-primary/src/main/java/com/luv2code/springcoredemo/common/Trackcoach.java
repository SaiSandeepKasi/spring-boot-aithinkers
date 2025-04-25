package com.luv2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class Trackcoach implements coach {
    @Override
    public String getdailyWorkout() {
        return "Run 5km daily workout";
    }
}
