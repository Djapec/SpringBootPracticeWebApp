package com.vacation.vacationWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VacationWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(VacationWebApplication.class, args);
	}

}
