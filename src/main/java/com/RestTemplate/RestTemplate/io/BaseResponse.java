package com.RestTemplate.RestTemplate.io;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class BaseResponse {

    private String status;
    private StatusMessage statusMessage;
    private Object data;

}
