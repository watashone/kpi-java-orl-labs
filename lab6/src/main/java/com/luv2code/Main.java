package com.luv2code;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Translator translator = new Translator();

        translator.addWord("hello", "привіт");
        translator.addWord("world", "світ");
        translator.addWord("how", "як");
        translator.addWord("are", "є");
        translator.addWord("you", "ти");
        translator.addWord("i", "я");
        translator.addWord("love", "люблю");
        translator.addWord("java", "джава");

        System.out.println("Хочете додати власні слова до словника? (yes/no)");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            while (true) {
                System.out.print("Введіть англійське слово (або 'exit' для завершення): ");
                String eng = scanner.nextLine().trim();
                if (eng.equalsIgnoreCase("exit")) break;

                System.out.print("Введіть український переклад: ");
                String ukr = scanner.nextLine().trim();

                translator.addWord(eng, ukr);
                System.out.println("Слово додано!\n");
            }
        }

        System.out.print("\nВведіть фразу англійською: ");
        String phrase = scanner.nextLine();

        String translation = translator.translate(phrase);
        System.out.println("Переклад: " + translation);
    }
}