package com.luv2code.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach coach;
    @Autowired
    public DemoController(coach mycoach) {
        coach = mycoach;

    }
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getdailyWorkout();
    }

}
