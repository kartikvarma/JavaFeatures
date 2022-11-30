package dev.kartikbvarma.features.jdk12.lang;

public class PatternMatchingExample {

    public static void main(String[] args) {

        Object obj = "Hello, Java12";
        if (obj instanceof String msg) {
            System.out.println(msg.length());
        }
    }
}
