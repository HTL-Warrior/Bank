package org.example;

public class Main {
        public static void main(String[] args) {
                Account Ando = new Account(696942011);
                Account Andri = new Account(2);
                Account Gezmiri = new Account(600000);

                Ando.deposit(200);
                Ando.withdraw(200);
                Ando.transfer(200, Andri);
        }
}
