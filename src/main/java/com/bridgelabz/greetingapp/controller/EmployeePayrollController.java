package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.DTO.EmployeeDTO;
import com.bridgelabz.greetingapp.DTO.ResponseDTO;
import com.bridgelabz.greetingapp.model.EmployeeData;
import com.bridgelabz.greetingapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {

    @Autowired
    IEmployeePayrollService iEmployeePayrollService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> createEmployee( @Valid @RequestBody EmployeeDTO employeeDTO ){
        ResponseDTO responseDTO = new ResponseDTO("Added Successfully", iEmployeePayrollService.addEmployee ( employeeDTO ));
        return new ResponseEntity<>( responseDTO, HttpStatus.ACCEPTED );
    }

    @GetMapping("/findEmployee/{id}")
    public ResponseEntity<ResponseDTO> findEmployee( @PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("ID found", iEmployeePayrollService.findEmployeeID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
    }

    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<ResponseDTO> deleteEmployee(@PathVariable int id){
        ResponseDTO responseDTO = new ResponseDTO("Succfully deleted", iEmployeePayrollService.deleteEmployeeID( id ));
        return new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/findAllEmployee")
    public List<EmployeeData> findAllGreeting(){
        return iEmployeePayrollService.findAllGreets();
    }
}
