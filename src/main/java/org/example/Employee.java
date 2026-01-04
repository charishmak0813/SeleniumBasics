package org.example;

import lombok.Getter;
import lombok.Setter;

public class Employee {
    @Setter @Getter
    private String firstName;
    @Setter @Getter
    private String lastName;
    @Setter @Getter
    private String department;
    @Setter @Getter
    private int id;


    public Employee(int id, String firstName, String lastName, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    public String getName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public void setId(int id){
        String idStr = " " + id;
        if(idStr.length() <=10)
            this.id = id;
    }

}
