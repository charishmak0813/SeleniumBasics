package org.example;

public class Dog  extends Animal {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
    @Override
    public void sound(){
        System.out.println("Dog  barks");
    }
}
