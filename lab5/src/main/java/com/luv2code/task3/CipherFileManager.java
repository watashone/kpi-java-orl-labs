package com.luv2code.task3;

import java.io.*;
import java.util.Scanner;

public class CipherFileManager {

    public static void encrypt(String inputFile, String outputFile, int key) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile);
             EncryptOutputStream eos = new EncryptOutputStream(new FileOutputStream(outputFile), key)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) != -1) {
                eos.write(buffer, 0, length);
            }
        }
    }

    public static void decrypt(String inputFile, String outputFile, int key) throws IOException {
        try (DecryptInputStream dis = new DecryptInputStream(new FileInputStream(inputFile), key);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, length);
            }
        }
    }

    public static int askKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter key (integer):");
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer key:");
            }
        }
    }

    public static String askFilepath(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
