package com.luv2code.task1;

import java.util.List;

class Bank {
    public void transfer(Account from, Account to, int amount) {
        if (from.getId() == to.getId()) {
            return;
        }

        Account firstLock = from.getId() < to.getId() ? from : to;
        Account secondLock = from.getId() < to.getId() ? to : from;

        synchronized (firstLock) {
            synchronized (secondLock) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                } else {
                    System.out.println("Недостатньо коштів на " + from);
                }
            }
        }
    }

    public long getTotalBalance(List<Account> accounts) {
        long total = 0;
        for (Account acc : accounts) {
            total += acc.getBalance();
        }
        return total;
    }
}
