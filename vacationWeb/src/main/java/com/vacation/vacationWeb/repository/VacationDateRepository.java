package com.vacation.vacationWeb.repository;

import com.vacation.vacationWeb.entity.VacationCompositeKey;
import com.vacation.vacationWeb.entity.VacationDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationDateRepository extends JpaRepository<VacationDate, VacationCompositeKey> {
    @Query(value="select * from vacation_dates",nativeQuery = true)
    List<VacationDate> readAllVacationDates();

    @Query(value="select * from vacation_dates where employee_email = :employee",nativeQuery = true)
    List<VacationDate> readAllVacationDatesByEmployee(String employee);

    @Query(value="select * from vacation_dates where employee_email = :employee",nativeQuery = true)
    List<VacationDate> findDateForEmployee(String employee);

    @Query(value="select * from vacation_dates where employee_email = :employee and year(end_date) = :year",nativeQuery = true)
    List<VacationDate> employeeByYear(Integer year, String employee);
}
