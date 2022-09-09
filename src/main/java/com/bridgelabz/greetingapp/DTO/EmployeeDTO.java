package com.bridgelabz.greetingapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z][a-z]{2,20}$", message = "Not allowed ")
    public String firstName;
    public int salary;
    public List<String> department;

}
