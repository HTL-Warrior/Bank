package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @Test
    void deposit() {
        Account account = new Account(1000);
        account.deposit(500);
        assertEquals(1500, account.checkBalance(), 0.01);
    }

    @Test
    void withdraw() {
        Account account = new Account(1000);
        account.withdraw(300);
        assertEquals(700, account.checkBalance(), 0.01);

        // Test for insufficient funds
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(800));
    }

    @Test
    void checkBalance() {
        Account account = new Account(1000);
        assertEquals(1000, account.checkBalance(), 0.01);
    }

    @Test
    void transfer() {
        Account account1 = new Account(1000);
        Account account2 = new Account(500);

        // Valid transfer
        account1.transfer(400, account2);
        assertEquals(600, account1.checkBalance(), 0.01);
        assertEquals(900, account2.checkBalance(), 0.01);

        // Test for insufficient funds in transfer
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(700, account2));

        // Test for null account in transfer
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(100, null));
    }

    @Test
    void testDeposit() {
        Account account = new Account(0);
        account.deposit(100);
        assertEquals(100, account.checkBalance(), 0.01);

        // Test for invalid deposit amount
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }

    @Test
    void testWithdraw() {
        Account account = new Account(500);
        account.withdraw(200);
        assertEquals(300, account.checkBalance(), 0.01);

        // Test for withdrawal of zero or negative amounts
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-50));
    }

    @Test
    void testCheckBalance() {
        Account account = new Account(750);
        assertEquals(750, account.checkBalance(), 0.01);

        Account emptyAccount = new Account(0);
        assertEquals(0, emptyAccount.checkBalance(), 0.01);
    }

    @Test
    void testTransfer() {
        Account account1 = new Account(300);
        Account account2 = new Account(700);

        // Test valid transfer
        account1.transfer(100, account2);
        assertEquals(200, account1.checkBalance(), 0.01);
        assertEquals(800, account2.checkBalance(), 0.01);

        // Test invalid transfer (amount > balance)
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(400, account2));

        // Test null target account
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(50, null));
    }
}
