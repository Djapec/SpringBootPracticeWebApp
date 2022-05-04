package com.vacation.vacationWeb.service.impl;

import com.vacation.vacationWeb.entity.Employee;
import com.vacation.vacationWeb.entity.VacationDate;
import com.vacation.vacationWeb.repository.EmployeeRepository;
import com.vacation.vacationWeb.repository.VacationDateRepository;
import com.vacation.vacationWeb.service.VacationDateService;
import com.vacation.vacationWeb.util.Shared;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@Service
public class VacationDateServiceImpl implements VacationDateService {

    @Autowired
    VacationDateRepository vacationDateRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    Shared shared;

    public int totalUsedVacationDays(List<VacationDate> data) {
        int iterator = 0;
        for (VacationDate emp: data) {
            iterator += shared.getListOfDate(emp.getVacationCompositeKey().getStartDate(),emp.getEndDate()).size();
        }
        return iterator;
    }

    public int totalNumberOfUnusedVacationDays(){
        List<VacationDate> data = vacationDateRepository.findAll();
        int totalDays = employeeRepository.totalVacationDays();
        int totalUsedDays = totalUsedVacationDays(data);
        return totalDays - totalUsedDays;
    }

    public float averageNumberOfUnusedVacationDays(){
        return (float)totalNumberOfUnusedVacationDays() / employeeRepository.readEmployees().size();
    }

    public Float percentageOfEmployeesThatUsedHoleVacation(Integer year){
        List<Employee> data = employeeRepository.employeesForCurrentYear(year);
        float total = 0;
        for(Employee emp: data){
           int i = totalUsedVacationDays(vacationDateRepository.
                    employeeByYear(year,emp.getEmployeeCompositeKey().getEmployee()));
           if (i >= employeeRepository.
                   totalVacationDaysByYearForEmployee(year,emp.getEmployeeCompositeKey().getEmployee())){
               total++;
           }
        }
        return (total/(float)data.size())*100;
    }

    public Map<String, Integer> listDate(List<VacationDate> data){
        Map<String, Integer> mapOfMonthCounter = new java.util.HashMap<>(Map.ofEntries(
                entry("January", 0),
                entry("February", 0),
                entry("March", 0),
                entry("April", 0),
                entry("May", 0),
                entry("June", 0),
                entry("July", 0),
                entry("August", 0),
                entry("September", 0),
                entry("October", 0),
                entry("November", 0),
                entry("December", 0)
        ));
        for(VacationDate emp: data) {
            List<LocalDate> daysRange = shared.getListOfDate(emp.getVacationCompositeKey().getStartDate(),emp.getEndDate());

            for(LocalDate date: daysRange){
                String month = shared.capitalize(String.valueOf(date.getMonth()));
                if (mapOfMonthCounter.containsKey(month)){
                    mapOfMonthCounter.put(month, mapOfMonthCounter.get(month) + 1);
                }
            }
        }
        return mapOfMonthCounter;
    }
}

