package com.example.Multi_Email.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailResponse {
	
	private String message;
	private Object data;
	private Integer status;
	
	public EmailResponse(String message, Object data, Integer status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

}
