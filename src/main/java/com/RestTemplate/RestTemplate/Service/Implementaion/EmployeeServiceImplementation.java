package com.RestTemplate.RestTemplate.Service.Implementaion;

import com.RestTemplate.RestTemplate.Constants.MessageCodes;
import com.RestTemplate.RestTemplate.DTO.EmployeeDto;
import com.RestTemplate.RestTemplate.Entity.Employee;
import com.RestTemplate.RestTemplate.Repository.EmployeeRepository;
import com.RestTemplate.RestTemplate.Service.EmployeeService;
import com.RestTemplate.RestTemplate.io.BaseResponse;
import com.RestTemplate.RestTemplate.io.StatusMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public BaseResponse processLogin(EmployeeDto request) throws Exception {
        Employee employee = employeeRepository.findByEmail(request.getEmail());
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        employeeDto.setPassword(null);
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.LOGIN)
                        .build())
                .data(employeeDto)
                .build();
    }

    @Override
    public BaseResponse processCreate(EmployeeDto request) throws Exception {
        Employee employee=new Employee();
        BeanUtils.copyProperties(request, employee);
        employeeRepository.save(employee);
        request.setPassword(null);
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.Employee)
                        .build())
               .data(employee)
                .build();

    }

    @Override
    public BaseResponse UpdateEmployee(EmployeeDto employeeDto, Long id) throws Exception {
        Employee employee = employeeRepository.getById(id);
        BeanUtils.copyProperties(employeeDto,employee);
       employee.setId(id);
        employeeRepository.save(employee);
        return BaseResponse.builder()
               .status(MessageCodes.SUCCESS)
               .statusMessage(StatusMessage.builder()
                       .code(MessageCodes.SUCCESS)
                       .description(MessageCodes.SUCCESS_UP)
                       .build())
               .data(employeeDto)
                .build();
    }

    @Override
    public BaseResponse ReteriveAll() throws Exception {
        List<Employee> employee = employeeRepository.findAll();
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.FILTERED)
                        .build())
                .data(employee)
                .build();
    }

    @Override
    public BaseResponse ReteriveByid(Long id) throws Exception {

        Optional<Employee> employee = employeeRepository.findById(id);
        return BaseResponse.builder()
                .status(MessageCodes.SUCCESS)
                .statusMessage(StatusMessage.builder()
                        .code(MessageCodes.SUCCESS)
                        .description(MessageCodes.SUCCESS_UP)
                        .build())
                .data(employee)
                .build();

    }

    @Override
    public BaseResponse DeleteEmployee(Long id) throws Exception {
        Employee employee = employeeRepository.getById(id);
        employeeRepository.delete(employee);
        return BaseResponse.builder()
               .status(MessageCodes.SUCCESS)
               .statusMessage(StatusMessage.builder()
                       .code(MessageCodes.SUCCESS)
                       .description(MessageCodes.SUCCESS_DEL)
                       .build())
                .build();
    }
}
