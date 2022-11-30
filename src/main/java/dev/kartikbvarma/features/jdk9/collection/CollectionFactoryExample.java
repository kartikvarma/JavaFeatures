package dev.kartikbvarma.features.jdk9.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryExample {

    public static void main(String[] args) {
        List<String> names = List.of("John", "Jacob", "JingleheimerSmith"); // <1>
        Set<String> namesAgain = Set.of("Ina", "Mina", "Tika"); // <2>
        Map<String, String> janeDoe = Map.of("fist-name", "Jane", "last-name", "Doe", "date-of-birth", "1947-08-15"); // <3>
    }

}
