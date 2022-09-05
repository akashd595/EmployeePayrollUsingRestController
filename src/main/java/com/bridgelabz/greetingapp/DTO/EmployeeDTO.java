package com.bridgelabz.greetingapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @Pattern(regexp = "^[A-Z][a-z]{2,20}$", message = "Not allowed ")
    public String firstName;
    public int salary;

}
