package com.luv2code.task4;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter URL to analyze tags:");
        String url = scanner.nextLine();

        try {
            Map<String, Integer> tagFrequency = TagFrequencyCounter.countTags(url);

            System.out.println("\nTags sorted lexicographically:");
            TagFrequencyCounter.printSortedByTag(tagFrequency);

            System.out.println("\nTags sorted by frequency:");
            TagFrequencyCounter.printSortedByFrequency(tagFrequency);

        } catch (IOException e) {
            System.out.println("Error connecting to URL or processing: " + e.getMessage());
        }
    }
}
