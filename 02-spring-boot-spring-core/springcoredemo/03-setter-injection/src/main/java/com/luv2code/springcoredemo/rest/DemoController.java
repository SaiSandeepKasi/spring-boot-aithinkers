package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach coach;
    /*
    we use any method name instead of setname()
    example we can use dothestuff()as method name it will be runned because autowired
     */
    @Autowired
  public void setCoach(coach mycoach) {
        coach = mycoach;
    }
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getdailyWorkout();
    }

}
