package dev.kartikbvarma.features.jdk17.lang.sealed;

public sealed abstract class Animals implements Mammals permits SeaAnimals {

    @Override
    public String getName() {
        return null;
    }
}
