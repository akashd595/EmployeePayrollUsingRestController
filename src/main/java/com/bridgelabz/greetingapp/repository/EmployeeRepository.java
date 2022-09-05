package com.bridgelabz.greetingapp.repository;

import com.bridgelabz.greetingapp.model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeData, Integer> {

}
