package com.luv2code.task1;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class FileHandler {
    public static void saveLinesToFile(List<String> lines, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(lines);
        }
    }

    public static List<String> loadLinesFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<String>) ois.readObject();
        }
    }
}

