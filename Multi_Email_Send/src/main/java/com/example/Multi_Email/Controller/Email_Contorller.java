package com.example.Multi_Email.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Multi_Email.CommonUtils.CommonUtils;
import com.example.Multi_Email.Service.Email_Service;

import jakarta.mail.MessagingException;

@RestController
public class Email_Contorller {
	
	@Autowired
	private Email_Service email_Service;

	@PostMapping("sendEmail")
	  public  ResponseEntity<String> sendJobOpportunityEmail() 
	  {
		  try {
			return new ResponseEntity<>(email_Service.sendJobOpportunityEmail(CommonUtils.EMAILS) , HttpStatus.OK);
		} catch (MessagingException | javax.mail.MessagingException e) {
			e.printStackTrace();
			return null;
		}
	  }
	
	
}
