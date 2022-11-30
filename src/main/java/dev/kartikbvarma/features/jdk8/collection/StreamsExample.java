package dev.kartikvboreda.features.jdk8.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * An example of basic fuctionalities of Steams and some of the actions that can be performed on a stream.
 * Filter - takes a predicate (a boolean result function) and applies on the passed in element.
 * Map - Change the definition of value in the stream by applying some function on the passed in element
 * Reduce - accumulate the value in a stream
 *
 */
public class StreamsExample {

    public static List<String> createData() {
        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jacob");
        names.add("Jingleheimer");
        names.add("schmidt");

        return names;
    }

    public static void main(String[] args) {
        List<String> names = createData();

        // Stream and join strings with(or without) delimiter
        String commaSeparatedNames = names.stream()
                .collect(Collectors.joining(","));

        System.out.println("Comma Separated name  {" + commaSeparatedNames + "}");

        // Stream and filter
        List<String> namesWithJ = names.stream()
                .filter(s -> s.startsWith("J"))
                .collect(Collectors.toList());

        System.out.println("Names starting with J : {" + namesWithJ + "}");

        // Stream and map
        List<String> allCapsNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("All Capital Names " + allCapsNames);

        // Stream and reduce
        String concatName = names.stream()
                .reduce("", String::concat);
        System.out.println("Concat names :: " + concatName);


        // Stream and add to a collection
        Set<String> uniqueNames = new HashSet<>();
        uniqueNames.add("john");
        uniqueNames.add("javier");
        uniqueNames.add("jeane");

        names.stream()
                .map(String::toLowerCase)
                .filter(s -> s.startsWith("j"))
                .forEachOrdered(uniqueNames::add);

        System.out.println("Unique names with letter J : " + uniqueNames);

        // Stream and peek and find the fist element
        String nameWithS = names.stream()
                .peek(System.out::println)
                .filter(s -> s.startsWith("s"))
                .findFirst()
                .orElse("");

        System.out.println("Name starting with S : " + nameWithS);
    }
}
