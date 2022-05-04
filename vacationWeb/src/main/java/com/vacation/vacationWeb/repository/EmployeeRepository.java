package com.vacation.vacationWeb.repository;

import com.vacation.vacationWeb.entity.Employee;
import com.vacation.vacationWeb.entity.EmployeeCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeCompositeKey> {
    @Query(value = "select * from vacation_days_per_years where employee = :employee",nativeQuery = true )
    List<Employee> findByEmployee(String employee);

    @Query(value = "select DISTINCT(employee) from vacation_days_per_years",nativeQuery = true )
    List<String> readEmployees();

    @Query(value="select sum(total_vacation_days) from vacation_days_per_years",nativeQuery = true)
    Integer totalVacationDays();

    @Query(value="select * from vacation_days_per_years where year = :year", nativeQuery = true)
    List<Employee> employeesForCurrentYear(Integer year);

    @Query(value = "select total_vacation_days from vacation_days_per_years where year = :year and employee= :employee",nativeQuery = true)
    Integer totalVacationDaysByYearForEmployee(Integer year, String employee);
}
