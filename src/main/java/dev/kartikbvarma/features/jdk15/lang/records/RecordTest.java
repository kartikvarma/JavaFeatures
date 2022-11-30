package dev.kartikbvarma.features.jdk15.lang.records;

import static dev.kartikbvarma.features.jdk17.lang.Gender.DONT_CARE;

public class RecordTest {

    public static void main(String[] args) {
        var person = new person("John", "Smith", 35, DONT_CARE);
        System.out.println(person);
    }
}
