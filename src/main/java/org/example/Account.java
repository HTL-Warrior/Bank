package org.example;

public class Account {
    public float balance;

    public Account(float balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance ohne Geld!!.");
        }
        this.balance = balance;
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;
    }

    public void withdraw(float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance.");
        }
        balance -= amount;
    }
    public float checkBalance() {
        return balance;
    }

    public void transfer(float amount, Account anotherAccount) {
        if (anotherAccount == null) {
            throw new IllegalArgumentException("Account existiert nicht!");
        }
        this.withdraw(amount);
        anotherAccount.deposit(amount);
    }
}
