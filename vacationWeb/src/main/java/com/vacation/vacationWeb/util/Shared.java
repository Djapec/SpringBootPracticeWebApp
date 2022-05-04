package com.vacation.vacationWeb.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Shared {
    public List<LocalDate> getListOfDate(LocalDate start, LocalDate end){
        Period period = Period.between(start,end);
        return  Stream.iterate(start, date -> date.plusDays(1)).limit(period.getDays()+1).collect(Collectors.toList());
    }

    public String capitalize(String str){
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
