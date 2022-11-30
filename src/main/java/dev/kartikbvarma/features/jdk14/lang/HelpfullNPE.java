package dev.kartikbvarma.features.jdk14.lang;

public class HelpfullNPE {

    public static void main(String[] args) {
        String name = null;
        System.out.println(name.length());
    }
}
