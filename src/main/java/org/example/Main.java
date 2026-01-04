package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Employee emp = new Employee(12, "Test", "user", "Marketing");
        System.out.println(emp.getName("Test", "user"));
        Manager manager = new Manager(12, "Test", "user", "Marketing", "Manager");
        System.out.println(manager.getManager());


    }
}