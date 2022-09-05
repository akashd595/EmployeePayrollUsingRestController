package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import com.bridgelabz.greetingapp.model.EmployeeData;
import com.bridgelabz.greetingapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeData addEmployee(EmployeeDTO employeeDTO){
        EmployeeData et = new EmployeeData(employeeDTO);    //et is entity
        return employeeRepository.save(et);
    }
    public Optional<EmployeeData> findEmployeeID(int id){
        return employeeRepository.findById(id);
    }
    public Integer deleteEmployeeID(int id) {
        employeeRepository.deleteById(id);
        return id;
    }
    public List<EmployeeData> findAllGreets(){
        return employeeRepository.findAll();
    }
}
