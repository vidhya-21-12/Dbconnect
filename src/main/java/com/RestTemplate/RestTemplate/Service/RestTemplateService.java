package com.RestTemplate.RestTemplate.Service;

import com.RestTemplate.RestTemplate.Entity.Employee;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


@Service
public class RestTemplateService {
    private  static  final  String GET_ALL_STUDENT_API = "http://localhost:9000/employee/filterAll";
    private  static  final  String ADD_STUDENT_API = "http://localhost:9000/employee/add/employee";
    private  static  final  String GET_STUDENT_BYID_API = "http://localhost:9000/employee/filter/{id}";





    static RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> getAllEmployeeAPI(){
        HttpHeaders headers =  new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity= new HttpEntity<>("parameters",headers);
        String result = restTemplate.exchange(GET_ALL_STUDENT_API, HttpMethod.GET,entity,String.class).getBody();
        return ResponseEntity.ok(result);


    }

    public ResponseEntity<Employee> addEmployee(Employee employee){
        return restTemplate.postForEntity(ADD_STUDENT_API,employee,Employee.class);

    }

    public  Employee getEmployeeByid(Long id){
        Map<String,Long> param = new HashMap<String,Long>();
        param.put("id",id);
        return  restTemplate.getForObject(GET_STUDENT_BYID_API,Employee.class,param);

    }
}
