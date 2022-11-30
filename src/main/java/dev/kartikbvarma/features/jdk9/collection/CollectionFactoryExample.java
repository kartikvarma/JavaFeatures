package dev.kartikbvarma.features.jdk8.concurrency;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryExample {

    public static void main(String[] args) {
        List<String> names = List.of("John", "Jacob", "JingleheimerSmith");
        System.out.println(names);
        Set<String> namesAgain = Set.of("Ina", "Mina", "Tika");
        System.out.println(namesAgain);
        Map<String, String> janeDoe = Map.of("fist-name", "Jane", "last-name", "Doe", "date-of-birth", "1947-08-15");
        System.out.println(janeDoe);
    }

}
