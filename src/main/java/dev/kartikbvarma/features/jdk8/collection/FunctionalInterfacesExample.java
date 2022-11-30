package dev.kartikbvarma.features.jdk8.collection;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *  {@link Supplier}
 *  {@link Consumer}
 *  {@link Predicate}
 *  {@link Function}
 */
public class FunctionalInterfacesExample {


    public static void main(String[] args) {

        String name = "Hello World!";

        // Usecase -> delayed validation
        Supplier<String> supplier = () -> name.toUpperCase(Locale.ENGLISH);

        // Usecase ->
        Consumer<String> consumer1 = s -> {
            for (byte aByte : s.getBytes(StandardCharsets.UTF_8)) {
                System.out.println(aByte);
            }
        };
        Consumer<String> consumer = System.out::println;
        Function<String, Integer> function = String::length;

        consumer1.andThen(consumer).accept(supplier.get());

        System.out.println(function.apply(name));

        Predicate<String> isLengthGreaterThan2 = s -> s.length() > 2;

        System.out.println(isLengthGreaterThan2.test(name));


    }

}


