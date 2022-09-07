package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import com.bridgelabz.greetingapp.model.EmployeeData;
import com.bridgelabz.greetingapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeData addEmployee(EmployeeDTO employeeDTO){
        EmployeeData employeeData = new EmployeeData(employeeDTO);    //employeeData is entity
        return employeeRepository.save(employeeData);
    }
    public Optional<EmployeeData> findEmployeeID(int id){
        return employeeRepository.findById(id);
    }
    public EmployeeData updateEmployeeID(EmployeeDTO employeeDTO, int id){
        try{
            EmployeeData employeeData = employeeRepository.findById(id).get() ;
            employeeData.setFirstName(employeeDTO.getFirstName());
            employeeData.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employeeData);

        }catch (NoSuchElementException e){
            return null;
        }
    }
    public Integer deleteEmployeeID(int id) {
        employeeRepository.deleteById(id);
        return id;
    }
    public List<EmployeeData> findAllGreets(){
        return employeeRepository.findAll();
    }
}
