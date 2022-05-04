package com.vacation.vacationWeb.controller;

import com.vacation.vacationWeb.repository.EmployeeRepository;
import com.vacation.vacationWeb.repository.VacationDateRepository;
import com.vacation.vacationWeb.service.impl.EmployeeServiceImpl;
import com.vacation.vacationWeb.service.impl.VacationDateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    VacationDateServiceImpl vacationDate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    VacationDateRepository vacationDateRepository;

    @GetMapping(value = "/home")
    public ModelAndView test() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");

        Integer total = vacationDate.totalUsedVacationDays(vacationDateRepository.readAllVacationDates());
        mv.addObject("total", total);

        float avg = vacationDate.averageNumberOfUnusedVacationDays();
        mv.addObject("avg", String.format("%.02f", avg));

        float percent = vacationDate.percentageOfEmployeesThatUsedHoleVacation(2019);
        mv.addObject("percent", String.format("%.02f", percent));

        Map<String, Integer> montList = vacationDate.listDate(vacationDateRepository.readAllVacationDates());
        mv.addObject("monthList", montList.entrySet());

        return mv;
    }
}
