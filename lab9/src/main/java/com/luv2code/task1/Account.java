package com.luv2code.task1;

import java.util.concurrent.atomic.AtomicInteger;

class Account {
    private static final AtomicInteger idGenerator = new AtomicInteger(0);
    private final int id;
    private int balance;

    public Account(int initialBalance) {
        this.id = idGenerator.getAndIncrement();
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "Acc-" + id;
    }
}
