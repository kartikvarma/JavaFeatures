package dev.kartikbvarma.features.jdk15.lang.records;

import dev.kartikbvarma.features.jdk15.lang.Gender;

import java.util.random.RandomGenerator;

public record person(int id, String fName, String lName, int age, Gender gender) {

    person(String fName, String lName, int age, Gender gender) {
        this(RandomGenerator.getDefault().nextInt(), fName, lName, age, gender);
    }
}
