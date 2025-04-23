package com.luv2code.springboot.demo.mycoolapp.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // expose "/" that returns Hello world!
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    //expose a new end point for workout
    @GetMapping("/workout")
    public String getdailyworkout(){
        return "run in hard 5k ";
    }
    @GetMapping("/fortune")
    public String fortune(){
        return "Today is your lucky day ";
    }


}
