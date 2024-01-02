package com.accuweather.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Period {

    public static String of(int duration) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");

        LocalDate startDate = LocalDate.now();
        String startDateFormat = startDate.format(formatter);

        LocalDate endDate = startDate.plusDays(duration-1);
        String endDateFormat = endDate.format(formatter);
        return String.join(" - ", startDateFormat.toUpperCase(), endDateFormat.toUpperCase());
    }
}
