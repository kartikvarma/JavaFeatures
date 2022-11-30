package dev.kartikbvarma.features.jdk11.lang;

public class NewStringMethods {
    public static void main(String[] args) {

        var userName = "johndoe11";

        userName.isBlank();
        userName.lines();
        userName.repeat(2);
        userName.strip();
        userName.stripLeading();
        userName.stripTrailing();


    }
}
