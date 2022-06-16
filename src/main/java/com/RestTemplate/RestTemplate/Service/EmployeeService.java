package com.RestTemplate.RestTemplate.Service;

import com.RestTemplate.RestTemplate.DTO.EmployeeDto;
import com.RestTemplate.RestTemplate.io.BaseResponse;



public interface EmployeeService {

    BaseResponse processLogin(EmployeeDto request) throws Exception;
    BaseResponse processCreate(EmployeeDto request) throws Exception;
    BaseResponse UpdateEmployee(EmployeeDto employeeDto, Long id)throws Exception;
    BaseResponse ReteriveAll() throws  Exception;
    BaseResponse  ReteriveByid(Long id)throws  Exception;
    BaseResponse DeleteEmployee(Long id)throws Exception;


}
