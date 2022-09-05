package com.bridgelabz.greetingapp.model;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private int id;
    private String firstName;
    private String lastName;
    private int salary ;
    private String note;

    public EmployeeData() {
    }

    public EmployeeData(EmployeeDTO employeeDTO){
        this.id = id;
        this.firstName = employeeDTO.getFirstName();
        this.salary = employeeDTO.getSalary();

    }

    public EmployeeData(int id, String firstName, String lastName, int salary, String note) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}