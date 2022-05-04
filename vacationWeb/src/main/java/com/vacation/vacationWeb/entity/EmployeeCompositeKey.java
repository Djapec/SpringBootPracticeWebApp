package com.vacation.vacationWeb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

import javax.persistence.Embeddable;


import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class EmployeeCompositeKey implements Serializable {

    @Column(name = "employee", nullable = false)
    private String employee;

    @Column(name = "year", nullable = false)
    private String year;

    public EmployeeCompositeKey(String employee, String year) {
        this.employee = employee;
        this.year = year;
    }

    public EmployeeCompositeKey() {

    }
}