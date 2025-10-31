package com.luv2code.task3;

public class Main {
    public static void main(String[] args) {

        int key = CipherFileManager.askKey();

        String inputFile = CipherFileManager.askFilepath("Enter input file path for encryption:");
        String encryptedFile = CipherFileManager.askFilepath("Enter output file path to save encrypted data:");

        try {
            CipherFileManager.encrypt(inputFile, encryptedFile, key);
            System.out.println("File encrypted successfully.");
        } catch (Exception e) {
            System.out.println("Encryption error: " + e.getMessage());
            return;
        }

        String encryptedInputFile = CipherFileManager.askFilepath("Enter encrypted file path for decryption:");
        String decryptedOutputFile = CipherFileManager.askFilepath("Enter output file path to save decrypted data:");

        try {
            CipherFileManager.decrypt(encryptedInputFile, decryptedOutputFile, key);
            System.out.println("File decrypted successfully.");
        } catch (Exception e) {
            System.out.println("Decryption error: " + e.getMessage());
        }
    }
}

