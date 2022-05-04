package com.vacation.vacationWeb.controller;

import com.vacation.vacationWeb.repository.EmployeeRepository;
import com.vacation.vacationWeb.repository.VacationDateRepository;
import com.vacation.vacationWeb.service.impl.EmployeeServiceImpl;
import com.vacation.vacationWeb.service.impl.VacationDateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @Autowired
    VacationDateServiceImpl vacationDate;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    VacationDateRepository vacationDateRepository;

    @GetMapping("/employees")
    public ModelAndView UserDetails() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("employees");

        mv.addObject("empList", employeeRepository.readEmployees());

        return mv;
    }
}
