package org.example;

import lombok.Getter;
import lombok.Setter;

public class Manager extends Employee {
    @Setter @Getter
    private String role;
    public Manager(int id, String firstName, String lastName, String department, String role){
        super( id, firstName, lastName,department );
        this.role = role;
    }
    public String  getManager(){
        return super.getFirstName()+ " " +super.getLastName() + "is " + super.getDepartment() + " " + role  ;
    }

}
