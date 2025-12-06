package com.luv2code.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankTest {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        List<Account> accounts = new ArrayList<>();
        int numberOfAccounts = 100;
        int numberOfThreads = 2000;

        Random rand = new Random();
        for (int i = 0; i < numberOfAccounts; i++) {
            accounts.add(new Account(1000 + rand.nextInt(5000)));
        }

        long startTotal = bank.getTotalBalance(accounts);
        System.out.println("Початкова сума в банку: " + startTotal);

        ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < numberOfThreads; i++) {
            executor.submit(() -> {
                Account from = accounts.get(rand.nextInt(numberOfAccounts));
                Account to = accounts.get(rand.nextInt(numberOfAccounts));
                int amount = rand.nextInt(500); // Випадкова сума

                bank.transfer(from, to, amount);
            });
        }

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("Всі транзакції завершено.");
        } else {
            System.out.println("Таймаут виконання!");
        }

        long endTotal = bank.getTotalBalance(accounts);
        System.out.println("Кінцева сума в банку:   " + endTotal);

        if (startTotal == endTotal) {
            System.out.println("Тест пройдено успішно! Баланс зійшовся.");
        } else {
            System.err.println("ПОМИЛКА! Баланс не сходиться. Різниця: " + (startTotal - endTotal));
        }
    }
}
