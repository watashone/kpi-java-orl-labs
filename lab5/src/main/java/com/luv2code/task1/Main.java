package com.luv2code.task1;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter text file path to read lines:");
            String textFile = scanner.nextLine();

            List<String> lines = new ArrayList<>();
            try (BufferedReader br = Files.newBufferedReader(Path.of(textFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            System.out.println("Enter file path to save serialized lines:");
            String serializedFile = scanner.nextLine();

            FileHandler.saveLinesToFile(lines, serializedFile);

            List<String> loadedLines = FileHandler.loadLinesFromFile(serializedFile);

            String maxWordsLine = MaxWordsLineFinder.findLineWithMaxWords(loadedLines);

            System.out.println("Line with maximum words:");
            System.out.println(maxWordsLine);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

