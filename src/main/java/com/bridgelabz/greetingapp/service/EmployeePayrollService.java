package com.bridgelabz.greetingapp.service;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import com.bridgelabz.greetingapp.exception.CustomException;
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
        EmployeeData employeeData = new EmployeeData(employeeDTO);    //employeeData is entity
        return employeeRepository.save(employeeData);
    }
    public Optional<EmployeeData> findEmployeeID(int id){
        if(employeeRepository.findById(id).isPresent()){
            return employeeRepository.findById(id);
        }else {
            throw new CustomException("Employee with "+id+" id is not found");
        }
    }
    /**
     * Used try catch block because employeeRepository.findById(id).get() was giving NoSuchElementException
     * exception when it was unable to find the ID in the Database
     * */
//    public EmployeeData updateEmployeeID(EmployeeDTO employeeDTO, int id){
//        try{
//            EmployeeData employeeData = employeeRepository.findById(id).get();
//            employeeData.setFirstName(employeeDTO.getFirstName());
//            employeeData.setSalary(employeeDTO.getSalary());
//            return employeeRepository.save(employeeData);
//
//        }catch (NoSuchElementException e){
//            return null;
//        }
//    }
    public EmployeeData updateEmployeeID(EmployeeDTO employeeDTO, int id){
        if(employeeRepository.findById(id).isPresent()) {
            EmployeeData employeeData = employeeRepository.findById(id).get();
            employeeData.setFirstName(employeeDTO.getFirstName());
            employeeData.setSalary(employeeDTO.getSalary());
            return employeeRepository.save(employeeData);
        }else{
            throw new CustomException("Employee with "+id+" id is not found");
        }
    }
    public Integer deleteEmployeeID(int id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return id;
        }else{
            throw new CustomException("Employee with "+id+" id is not found");
        }
    }
    public List<EmployeeData> findAllGreets(){
        if(!employeeRepository.findAll().isEmpty()){
            return employeeRepository.findAll();
        }else {
            throw new CustomException("Table is Empty");
        }
    }
}
