package dev.kartikbvarma.features.jdk15.lang.sealed;

public sealed abstract class Animals implements Mammals permits SeaAnimals {

    @Override
    public String getName() {
        return null;
    }
}
