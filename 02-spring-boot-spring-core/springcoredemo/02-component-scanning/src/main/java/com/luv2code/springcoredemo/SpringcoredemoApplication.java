package com.luv2code.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
in this we are using different packages to showcase that component scanner in spring application will scan component
in same package and in its sub-package also.
here we used or crated different packages like rest and common and transfered the classes and interfaces into it to
check whether the component scanner will scan the sub-package or not .it worked and it scanned
 */
/*
you can scan explicitly using
@SpringBootApplication
scanBasePackages ={"com.luv2.code.springcoredemo",
"com.luv2code.util"})
 */
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
