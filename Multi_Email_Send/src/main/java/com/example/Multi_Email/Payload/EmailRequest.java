package com.example.Multi_Email.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {

	private String fromEmail;
	
	private String[] toEmail;
	
}
