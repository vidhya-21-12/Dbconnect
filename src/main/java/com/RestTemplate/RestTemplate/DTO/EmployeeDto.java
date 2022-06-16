package com.RestTemplate.RestTemplate.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class EmployeeDto {

    private String name;
    private String dept;
    private String experience;
    private String email;
    private String phonenumber;
    private String password;


}
