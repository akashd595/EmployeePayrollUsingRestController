package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import com.bridgelabz.greetingapp.model.EmployeeData;


import java.util.List;
import java.util.Optional;

public interface IEmployeePayrollService {

//    public Greeting addGreeting(Greeting greets);
    public EmployeeData addEmployee(EmployeeDTO greetingDTO);
    public EmployeeData updateEmployeeID(EmployeeDTO employeeDTO, int id);

    public Optional<EmployeeData> findEmployeeID(int id);
//    public void deleteEmployeeID(int id);
    public Integer deleteEmployeeID(int id);

    public List<EmployeeData> findAllGreets();
}
