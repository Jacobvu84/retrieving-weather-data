package com.accuweather.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String dateInformation(int day) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
        LocalDate date = LocalDate.now().plusDays(day-1);;

        return date.format(formatter).toUpperCase();
    }

    public static String dayValue(int day){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d");
        LocalDate date = LocalDate.now().plusDays(day-1);;
        return date.format(formatter).toUpperCase();
    }
}
