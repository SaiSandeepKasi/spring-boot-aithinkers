package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach coach;

    @Autowired
  public void setCoach(coach thecoach) {
        coach = thecoach;
    }
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getdailyWorkout();
    }

}
