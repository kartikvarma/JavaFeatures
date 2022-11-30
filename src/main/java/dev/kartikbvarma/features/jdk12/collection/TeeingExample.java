package dev.kartikbvarma.features.jdk12.collection;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.teeing;

public class TeeingExample {
    public static void main(String[] args) {
        double mean = IntStream.range(1,100)
                .boxed()
                .collect(teeing(
                        summarizingDouble(i -> i),
                        counting(),
                        (sum, count) -> sum.getSum() / count
                ));

        System.out.println(mean);


        var range = Stream.of(75000L, 85000L, 95000L, 105000L, 115000L, 125000L)
                .collect(teeing(
                        minBy(Long::compareTo),
                        maxBy(Long::compareTo),
                        Range::of));

        System.out.println(range);
    }

    private static class Range {
        private final long min;
        private final long max;

        private Range(long min, long max) {
            this.min = min;
            this.max = max;
        }

        public static Range of(Optional<Long> min, Optional<Long> max) {
            return new Range(min.orElse(0L), max.orElse(0L));
        }

        private String convertToShortFormat(long number){
            var shortNumberFormat =
                    NumberFormat.getCompactNumberInstance(
                            new Locale("en", "US"), NumberFormat.Style.SHORT);

            shortNumberFormat.setMaximumFractionDigits(2);
            return shortNumberFormat.format(number);
        }
        @Override
        public String toString() {
            return "Min is $"+ convertToShortFormat(min)
                    +" Max is $"+convertToShortFormat(max);
        }
    }


}

