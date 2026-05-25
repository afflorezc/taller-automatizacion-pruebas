package co.edu.udea.certificacion.taller.shopping.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import co.edu.udea.certificacion.taller.shopping.models.InputDate;

public class DateManipulation {

    private static final List<String> MONTH_NAMES = new ArrayList<>(
        Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
                            ));

    public static String getMonthName(int monthValue){
        return MONTH_NAMES.get(monthValue-1);
    }

    public static InputDate transformsDate(LocalDate date){
        int monthDay = date.getDayOfMonth();
        String monthName = getMonthName(date.getMonthValue());
        int year = date.getYear();
        return new InputDate(monthDay, monthName, year);
    }

}
