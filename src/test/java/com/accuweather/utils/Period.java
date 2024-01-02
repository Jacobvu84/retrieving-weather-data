package com.accuweather.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * The Period class represents a time period in terms of dates. It provides a static method 'of'
 * that takes a duration in days and returns a formatted string representing the start and end dates
 * of the period. The dates are formatted using the "MMMM d" pattern, which represents the month
 * name and day of the month (e.g., "January 1").
 * Example Usage:
 * ```
 * String periodString = Period.of(7);
 * System.out.println(periodString);
 * ```
 * This will output a string representing a one-week period, starting from the current date.
 **/
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
