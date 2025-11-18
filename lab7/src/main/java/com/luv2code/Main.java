package com.luv2code;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] input = {"Java", "C++", "Python", "Go", "JavaScript", "Rust", "C"};

        System.out.println("Вхідний масив: " + Arrays.toString(input));

        double averageLength = Arrays.stream(input)
                .mapToInt(String::length)
                .average()
                .orElse(0);

        System.out.printf("Середня довжина: %.2f%n", averageLength);
        System.out.println("---");

        String[] shorterStrings = Arrays.stream(input)
                .filter(s -> s.length() < averageLength)
                .toArray(String[]::new);

        System.out.println("Рядки коротші за середнє: " + Arrays.toString(shorterStrings));

        String[] longerStrings = Arrays.stream(input)
                .filter(s -> s.length() > averageLength)
                .toArray(String[]::new);

        System.out.println("Рядки довші за середнє:   " + Arrays.toString(longerStrings));
    }
}
