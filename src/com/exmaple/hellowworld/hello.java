package com.exmaple.hellowworld;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class hello {

    public static Calendar getWeekInfo(String date, int i) {
        LocalDate parse = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        Calendar calendar = Calendar.getInstance();
        calendar.set(parse.getYear(), parse.getMonthValue() - i, parse.getDayOfMonth());
        calendar.setFirstDayOfWeek(Calendar.WEDNESDAY);
        calendar.setMinimalDaysInFirstWeek(7);
        System.out.println("calendar.getTime()1 = " + calendar.getTime());
        return calendar;
    }

    public static void main(String[] args) {
        Calendar weekInfo1 = getWeekInfo("20200701", 1);
        Calendar weekInfo2 = getWeekInfo("20200701", 1);
        System.out.println("weekInfo1.get(Calendar.DAY_OF_WEEK) = " + weekInfo1.get(Calendar.WEEK_OF_YEAR));
        System.out.println("weekInfo1.get(Calendar.MONTH) = " + weekInfo1.get(Calendar.MONTH));
        System.out.println("weekInfo1.get(Calendar.DAY_OF_MONTH) = " + weekInfo1.get(Calendar.DAY_OF_MONTH));
        System.out.println();
        weekInfo2.add(Calendar.DATE, 6);
        System.out.println("weekInfo2.get(Calendar.DAY_OF_WEEK) = " + weekInfo2.get(Calendar.WEEK_OF_YEAR));
        System.out.println("weekInfo2.get = " + weekInfo2.get(Calendar.MONTH));
        System.out.println("weekInfo2.get(Calendar.DAY_OF_MONTH) = " + weekInfo2.get(Calendar.DAY_OF_MONTH));
        System.out.println();
        weekInfo2.add(Calendar.DATE, -7);
        System.out.println("weekInfo2.get(Calendar.DAY_OF_WEEK) = " + weekInfo2.get(Calendar.WEEK_OF_YEAR));
        System.out.println("weekInfo2.get(Calendar.MONTH) = " + weekInfo2.get(Calendar.MONTH));
        System.out.println("weekInfo2.get(Calendar.DAY_OF_MONTH) = " + weekInfo2.get(Calendar.DAY_OF_MONTH));
        System.out.println();
        weekInfo2.add(Calendar.DATE, -6);
        System.out.println("weekInfo2.get(Calendar.DAY_OF_WEEK) = " + weekInfo2.get(Calendar.WEEK_OF_YEAR));
        System.out.println("weekInfo2.get = " + weekInfo2.get(Calendar.MONTH));
        System.out.println("weekInfo2.get(Calendar.DAY_OF_MONTH) = " + weekInfo2.get(Calendar.DAY_OF_MONTH));
    }

}
