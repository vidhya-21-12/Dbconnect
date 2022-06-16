package com.RestTemplate.RestTemplate.Controller;

import com.RestTemplate.RestTemplate.Constants.NamespaceConstant;
import com.RestTemplate.RestTemplate.DTO.EmployeeDto;
import com.RestTemplate.RestTemplate.Service.EmployeeService;
import com.RestTemplate.RestTemplate.io.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = NamespaceConstant.LOGIN)
    public ResponseEntity<BaseResponse> processLogin(@RequestBody EmployeeDto req) throws Exception {
        BaseResponse response = employeeService.processLogin(req);
        return ResponseEntity.ok(response);
    }
    @PostMapping(value = NamespaceConstant.CREATE_EMPLOYEE)
    public ResponseEntity<BaseResponse> processSignup(@RequestBody EmployeeDto req) throws Exception {
        BaseResponse response = employeeService.processCreate(req);
        return ResponseEntity.ok(response);
    }


    @PutMapping(value = NamespaceConstant.UPDATE_EMPLOYEE)
    public ResponseEntity<BaseResponse> Updateuser(@RequestBody EmployeeDto employeeDto, @PathVariable Long id) throws Exception {
        BaseResponse response = employeeService.UpdateEmployee(employeeDto,id);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = NamespaceConstant.FILTER_ALL)
    public ResponseEntity<BaseResponse> FilterAll() throws Exception {
        BaseResponse response = employeeService.ReteriveAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = NamespaceConstant.FILTER_BYID)
    public ResponseEntity<BaseResponse> FilterAllByid(@PathVariable Long id) throws Exception {
        BaseResponse response = employeeService.ReteriveByid(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = NamespaceConstant.DELETE_EMPLOYEE)
    public ResponseEntity<BaseResponse> Deleteuser(@PathVariable Long id) throws Exception {
        BaseResponse response =employeeService.DeleteEmployee(id);
        return ResponseEntity.ok(response);
    }

}
