package dev.kartikbvarma.features.jdk13.lang;

import java.util.stream.LongStream;

public class SwitchExpressionsYield {

    public enum Multiples {
        SQUARE, CUBE;
    }

    public static double multiple(Multiples multiple, long number) {
        return switch (multiple) {
            case SQUARE ->  {
                yield Math.pow(number, 2);
            }
            case CUBE -> {
                yield Math.pow(number, 3);
            }
        };
    }

    public static void main(String[] args) {
        LongStream.rangeClosed(1,10)
                .boxed()
                .map(num -> multiple(Multiples.SQUARE, num))
                .forEach(System.out::println);
    }
}
