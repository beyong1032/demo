package com.example.demo;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @Author:litong
 * @Description:
 * @Date:Create on 2018/4/19 14:47
 */
public class TestNewDate {

    public static void main(String[] args) {
        LocalDate ld=LocalDate.now();
        System.out.println(ld);
        System.out.println(ld.getDayOfYear()+"-"+ld.getDayOfMonth()+"-"+ld.getDayOfWeek());
        System.out.println(ld.getYear()+","+ld.getMonth()+","+ld.getMonthValue()+","+ld.getEra()+","+ld.getChronology());

        Clock clock=Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.getZone());
        System.out.println(clock.millis());
    }
}
