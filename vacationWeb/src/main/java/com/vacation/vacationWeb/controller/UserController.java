package com.vacation.vacationWeb.controller;

import com.vacation.vacationWeb.repository.EmployeeRepository;
import com.vacation.vacationWeb.repository.VacationDateRepository;
import com.vacation.vacationWeb.service.impl.EmployeeServiceImpl;
import com.vacation.vacationWeb.service.impl.VacationDateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class UserController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    VacationDateServiceImpl vacationDate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    VacationDateRepository vacationDateRepository;

    @GetMapping("/user")
    public ModelAndView UserDetails(@RequestParam String id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("user");
        mv.addObject("user",id);

        mv.addObject("daysPerYear",employeeRepository.findByEmployee(id));

        mv.addObject("unusedDaysPerYear",employeeService.employeeUnusedDaysPerYear(id));

        Map<String, Integer> montList = vacationDate.listDate(vacationDateRepository.readAllVacationDatesByEmployee(id));
        mv.addObject("monthList", montList.entrySet());

        return mv;
    }
}
