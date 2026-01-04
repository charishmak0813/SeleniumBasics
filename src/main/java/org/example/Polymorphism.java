package org.example;

public class Polymorphism {
    public static void main(String[] args) {
        Polymorphism p = new Polymorphism();
        System.out.println(p.add(5, 5));
    }

        public int add(int a, int b){
            return a + b;
        }
        public double add( double a, double b ){
            return a + b;
        }
        public double add(int a, double b){
        return a + b;
        }
        public double add(double a, int b){
        return a + b;
         }
         // Overriding

}
