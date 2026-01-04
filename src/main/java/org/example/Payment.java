package org.example;
// Interface (100% Abstraction)
interface Payment {

    void pay();
    int TIMEOUT = 30;   // public static final by default
}

class CardPayment implements Payment {
    public static void main(String[] args){
        CardPayment c = new CardPayment();
        c.pay();
        c.printTimeout();

    }

    public void pay() {
        System.out.println("Paid using Card");
    }
    void printTimeout() {
        System.out.println(Payment.TIMEOUT);// not super
    }
}
