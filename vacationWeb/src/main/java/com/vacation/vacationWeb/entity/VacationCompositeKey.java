package com.vacation.vacationWeb.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class VacationCompositeKey implements Serializable {

    @Column(name = "employee_email", nullable = false)
    private String employeeEmail;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    public VacationCompositeKey(String employeeEmail, LocalDate startDate) {
        this.employeeEmail = employeeEmail;
        this.startDate = startDate;
    }

    public VacationCompositeKey() {

    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
