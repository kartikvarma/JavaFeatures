package dev.kartikbvarma.features.jdk17.lang.sealed;

import dev.kartikbvarma.features.jdk17.lang.sealed.Animals;
import dev.kartikbvarma.features.jdk17.lang.sealed.Humans;

public sealed interface Mammals permits Humans, Animals {

    String getName();
}
