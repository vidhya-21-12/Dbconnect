package com.RestTemplate.RestTemplate.Repository;

import com.RestTemplate.RestTemplate.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

   Employee findByEmail(String email);
   //Optional<Employee> findById(Long id);
}
