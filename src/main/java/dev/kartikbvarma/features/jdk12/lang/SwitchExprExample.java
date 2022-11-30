package dev.kartikbvarma.features.jdk12.lang;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class SwitchExprExample {

    private enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    public static void main(String[] args) {
        List<Day> weekdays = Stream.of(Day.values())
                .filter(not(SwitchExprExample::isWeekend))
                .collect(Collectors.toList());

        System.out.println(weekdays);


    }

    private static boolean isWeekend(Day day) {
        return switch (day) {
            case TUESDAY, MONDAY, FRIDAY, THURSDAY, WEDNESDAY -> false;
            case SATURDAY, SUNDAY -> true;
        };
    }
}
