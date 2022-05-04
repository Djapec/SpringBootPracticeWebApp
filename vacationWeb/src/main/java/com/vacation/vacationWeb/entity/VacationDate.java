package com.vacation.vacationWeb.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="VACATION_DATES")
public class VacationDate {

    @EmbeddedId
    private VacationCompositeKey vacationCompositeKey;

    @Column(name = "end_date")
    private LocalDate endDate;
}
