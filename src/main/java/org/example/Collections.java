package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Collections {

    public static void main(String[] args) {

        int[] marks = new int[4];

        int[] score = {1, 2, 3, 3};

        // Enhanced for-loop
        for (int i : score) {
            System.out.print(i + " ");
        }
        System.out.println();

        // ArrayList
        ArrayList<String> a = new ArrayList<>();
        a.add("rest");
        System.out.println(a);

        // Map
        Map<Integer, String> emp = new HashMap<>();
        emp.put(1, "test");
        System.out.println(emp);
    }

}