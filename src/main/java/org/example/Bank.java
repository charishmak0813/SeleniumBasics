package org.example;

// Abstraction

abstract class Bank {

    abstract void getInterestRate();

    void displayBank() {
        System.out.println("Bank services");
    }
}

class SBI extends Bank {
    void getInterestRate() {
        System.out.println("Interest: 7%");
    }
}
