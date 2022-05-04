package com.vacation.vacationWeb.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VACATION_DAYS_PER_YEARS")
public class Employee {

    @EmbeddedId
    EmployeeCompositeKey employeeCompositeKey;

    @Column(name = "total_vacation_days")
    private int totalVacationDays;

}
