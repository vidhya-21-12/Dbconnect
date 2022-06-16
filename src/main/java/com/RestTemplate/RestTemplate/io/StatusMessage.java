package com.RestTemplate.RestTemplate.io;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class StatusMessage {

	private String code; // 200  or 500
	private String description;// sucess  or internal error

}
