package com.example.Multi_Email.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Multi_Email.CommonUtils.CommonUtils;
import com.example.Multi_Email.Repo.Repository;

import jakarta.mail.MessagingException;

@Component
public class Email_Service {
	
	@Autowired
	private Repository emailRepo;

	
	
//
//    public  void main(String[] args) throws MessagingException, javax.mail.MessagingException {
//        // Send job opportunity email to the list of emails
//        sendJobOpportunityEmail(CommonUtils.EMAILS);
//    }

    public  String sendJobOpportunityEmail(List<String> emails) throws MessagingException, javax.mail.MessagingException {
        String subject = "Exciting Job Opportunity!";
        String message = "Dear candidate,\n\nWe are thrilled to inform you of a new job opening that matches your skills and experience! "
                       + "Please contact us or visit our website for more information and application details.\n\nBest regards,\nRecruitment Team";

        for (String email : emails) {
            System.out.println("Sending job opportunity email to: " + email);

            // Send email logic (pseudo-code, replace with actual email service logic)
            boolean sendEmail = CommonUtils.sendEmail(message, subject, email);  // Replace with actual email sending logic
            if (sendEmail) {
                System.out.println("Email sent successfully to " + email);
            } else {
                System.err.println("Failed to send email to " + email);
            }
        }
        
        return "Emails processed";
    }

    // Placeholder for email sending logic (replace with your email service implementation)
    public static boolean sendEmail(String subject, String message, String to) {
        System.out.println("Sending email to: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        return true;  // Simulate successful email send
    }
	
	
	
}
