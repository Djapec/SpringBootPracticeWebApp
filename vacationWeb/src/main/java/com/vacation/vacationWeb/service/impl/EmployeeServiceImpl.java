package com.vacation.vacationWeb.service.impl;

import com.vacation.vacationWeb.entity.Employee;
import com.vacation.vacationWeb.entity.VacationDate;
import com.vacation.vacationWeb.repository.EmployeeRepository;
import com.vacation.vacationWeb.repository.VacationDateRepository;
import com.vacation.vacationWeb.service.EmployeeService;
import com.vacation.vacationWeb.util.Shared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    VacationDateServiceImpl vacationDateService;

    @Autowired
    VacationDateRepository vacationDateRepository;

    @Autowired
    Shared shared;

    public Map<Integer, Integer> employeeUnusedDaysPerYear(String employee){
        Map<Integer, Integer> mapOfYearCounter = new java.util.HashMap<>();

        for(Employee emp: employeeRepository.findByEmployee(employee)){
            mapOfYearCounter.put(Integer.valueOf(emp.getEmployeeCompositeKey().getYear()),emp.getTotalVacationDays());
        }

        for(VacationDate emp: vacationDateRepository.readAllVacationDatesByEmployee(employee)) {
            List<LocalDate> daysRange = shared.getListOfDate(emp.getVacationCompositeKey().getStartDate(),emp.getEndDate());

            for(LocalDate date: daysRange){
                if (mapOfYearCounter.containsKey(date.getYear())){
                    mapOfYearCounter.put(date.getYear(), mapOfYearCounter.get(date.getYear()) - 1);
                }
            }
        }
        return mapOfYearCounter;
    }
}
