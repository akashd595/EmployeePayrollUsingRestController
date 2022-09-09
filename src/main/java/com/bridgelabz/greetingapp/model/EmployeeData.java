package com.bridgelabz.greetingapp.model;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import javax.persistence.*;
import java.util.List;

@Entity
public class EmployeeData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;
    private String firstName;
    private String lastName;
    private int salary;
    private String note;

    private String email;
    @ElementCollection
    @CollectionTable(name = "dept_list", joinColumns = @JoinColumn(name = "employee_id"))
    public List<String> department;

    public EmployeeData() {
    }

    public EmployeeData(EmployeeDTO employeeDTO) {
        this.firstName = employeeDTO.getFirstName();
        this.salary = employeeDTO.getSalary();
        this.department = employeeDTO.getDepartment();
        this.email = employeeDTO.getEmail();
    }

    public EmployeeData(int employeeId, String firstName, String lastName, int salary, String note, String email, List<String> department) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.note = note;
        this.email = email;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }
}