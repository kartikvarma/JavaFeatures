package dev.kartikbvarma.features.jdk15.lang.sealed;

public sealed interface Mammals permits Humans, Animals {

    String getName();
}
