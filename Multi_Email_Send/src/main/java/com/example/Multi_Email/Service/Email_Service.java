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
    		

    		String subject = "Seeking New Opportunities as a Java Developer";
    		String message = "<p>Dear Sir,</p>"
    		        + "<p>I hope this message finds you well. I am currently working at OPLInnovate as a Trainee Software Engineer, "
    		        + "where I have gained valuable hands-on experience in software development. I am now actively seeking new opportunities "
    		        + "to further develop my career, particularly as a Java Developer.</p>"
    		        + "<p>With a solid foundation in Java, Spring, and related technologies, I am eager to contribute my skills to a dynamic team. "
    		        + "I am passionate about tackling new challenges, enhancing system performance, and delivering innovative solutions.</p>"
    		        + "<p>Please find my resume attached for your review. I would greatly appreciate the opportunity to discuss how my skills and experience "
    		        + "align with potential openings in your organization.</p>"
    		        + "<p>Thank you for considering my application. I look forward to hearing from you.</p>";


        for (String email : emails) {
            System.out.println("Sending job opportunity email to: " + email);

            // Send email logic (pseudo-code, replace with actual email service logic)
            boolean sendEmail = CommonUtils.sendEmailWithEmbeddedSignature(message, subject, email , CommonUtils.RESUME_PATH , CommonUtils.SIGNATURE_PATH);  // Replace with actual email sending logic
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
