package com.RestTemplate.RestTemplate.Controller;


import com.RestTemplate.RestTemplate.Entity.Employee;
import com.RestTemplate.RestTemplate.Service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestTemplateAPIController {

    @Autowired
    RestTemplateService restTemplateService;

    @GetMapping("/resttemplate/AllEmployee")
    public ResponseEntity<ResponseEntity<String>> GetAllEmployeeAPI(){
        ResponseEntity<String> response = restTemplateService.getAllEmployeeAPI();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/resttemplate/AddEmployee")
    public ResponseEntity<ResponseEntity<Employee>> AddEmployeeAPI(@RequestBody Employee employee){
        ResponseEntity<Employee> response = restTemplateService.addEmployee(employee);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/resttemplate/getEmployeebyId/{id}")
    public ResponseEntity<Employee> GetEmployeeById( @PathVariable Long id){
       Employee response = restTemplateService.getEmployeeByid(id);
        return ResponseEntity.ok(response);
    }
    }

