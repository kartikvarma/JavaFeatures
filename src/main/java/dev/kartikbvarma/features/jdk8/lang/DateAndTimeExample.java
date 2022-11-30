package dev.kartikbvarma.features.jdk8.lang;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateAndTimeExample {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(Clock.systemUTC().instant());

        System.out.println(Clock.fixed(Instant.now(), ZoneId.systemDefault()));
    }
}
