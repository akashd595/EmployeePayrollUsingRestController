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
/**
 * Controller  class
 */

@RestController
@RequestMapping("/employee")
public class EmployeePayrollController {
    /**
     * Auto wired with Service class
     */
    @Autowired
    IEmployeePayrollService iEmployeePayrollService;

    @PostMapping("/addEmployee")
    public ResponseEntity<ResponseDTO> createEmployee( @Valid @RequestBody EmployeeDTO employeeDTO ){
        ResponseDTO responseDTO = new ResponseDTO("Added Successfully", iEmployeePayrollService.addEmployee ( employeeDTO ));
        return new ResponseEntity<>( responseDTO, HttpStatus.CREATED );
    }

    /**
     * Finding employee using its ID
     */
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

    /**
     * Updating Employee Using its ID
     * */
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseDTO> UpdateEmployee( @Valid @RequestBody EmployeeDTO employeeDTO, @PathVariable int id ){
        ResponseDTO responseDTO = new ResponseDTO("Updated", iEmployeePayrollService.updateEmployeeID( employeeDTO, id ));
        if(iEmployeePayrollService.updateEmployeeID( employeeDTO, id ) != null){
            return new ResponseEntity<>(responseDTO, HttpStatus.OK) ;
        }
        responseDTO.setMessage("ID not found");
        return new ResponseEntity<>(responseDTO,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAllEmployee")
    public List<EmployeeData> findAllGreeting(){
        return iEmployeePayrollService.findAllGreets();
    }
}
