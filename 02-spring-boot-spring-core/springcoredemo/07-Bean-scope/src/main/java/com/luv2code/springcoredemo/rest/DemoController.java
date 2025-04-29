package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private coach coach;
    private coach anotherCoach;

    @Autowired
  public DemoController(
          @Qualifier("cricketcoach") coach thecoach
        , @Qualifier("cricketcoach") coach theanotherCoach)
    {
            System.out.println("In constructor :"+getClass().getSimpleName());
        coach = thecoach;
        coach = theanotherCoach;
    }
    @GetMapping("/dailyworkout")
    public String getWorkout() {
        return coach.getdailyWorkout();
    }
    @GetMapping("/check")
    public String getCheck() {
        return "Comparing beans : coach == another coach "+  (coach == anotherCoach);
    }

}
