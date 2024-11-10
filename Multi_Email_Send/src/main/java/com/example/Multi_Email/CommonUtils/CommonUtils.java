package com.example.Multi_Email.CommonUtils;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.io.File;

public class CommonUtils {
	
	 // Static list of random email addresses
//    public static final List<String> EMAILS = List.of(
//        "dhaval.ajmera0718@gmail.com"
////        "kashyap3627@gmail.com"
//    );
    public static final List<String> EMAILS = List.of(
    	    "dhaval.ajmera0718@gmail.com",
    	    "career@tatvic.com",
    	    "hr@xomic.co.in",
    	    "jobs@panamaxil.com",
    	    "career@ifourtechnolab.com",
    	    "careers@anblicks.com",
    	    "hr@dataqinc.com",
	    	 "Neha.Sutar@mastercard.com" ,
		    "ankita.d@orosoft.com",
		     "ppriyambada@academian.com",
		     "shrutivinod.sonawane@tcs.com"

    	);

    public static String RESUME_PATH = "C:/Users/admin/Documents/KYC/Multiple-Email-Send-/Multi_Email_Send/DHAVALAJMERA07.pdf";
    public static String SIGNATURE_PATH="C:/Users/admin/Documents/KYC/Multiple-Email-Send-/Multi_Email_Send/signature.gif";
	
public static Boolean sendEmail(String message, String subject, String to) throws MessagingException {
		
		
		Boolean flag = false;
		//Variable for gmail
		String host="smtp.gmail.com";
		String from = "dhaval.ajmera123456@gmail.com";
		
//		to =to.trim();
		
		
		//get the system properties
		Properties properties = System.getProperties();
		System.err.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		System.err.println("2222222222222");
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		System.err.println("3333333333");
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {		//b		
				return new PasswordAuthentication("dhaval.ajmera123456@gmail.com", "duke dhjn xeqr hztb");
			}
			
			
			
		});
		System.err.println("44444444444");
		session.setDebug(true);
		System.err.println("session---------->" + session);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		m.setText(message);

		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		
		flag=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		System.err.println("FLAG------>" + flag);
		return flag;
	}
//---------------------------
public static Boolean sendEmailWithAttachment(String message, String subject, String to, String filePath) throws MessagingException {
    
    Boolean flag = false;
    String host = "smtp.gmail.com";
    String from = "dhaval.ajmera123456@gmail.com";  // Replace with your email
    String password = "duke dhjn xeqr hztb";  // Replace with your app password

    // Set up the properties for the SMTP connection
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // Create the session with an authenticator
    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
    });

    try {
        // Create a new email message
        MimeMessage m = new MimeMessage(session);
        m.setFrom(from);
        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        m.setSubject(subject);

        // Create the message body part for the text
        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setText(message);

        // Create the message body part for the attachment
        MimeBodyPart attachmentBodyPart = new MimeBodyPart();
        attachmentBodyPart.attachFile(new File(filePath));  // Attach the file

        // Create a multipart container for both parts
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textBodyPart);               // Add text part
        multipart.addBodyPart(attachmentBodyPart);          // Add attachment part

        // Set the multipart content to the message
        m.setContent(multipart);

        // Send the email
        Transport.send(m);
        System.out.println("Email with attachment sent successfully...");
        
        flag = true;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return flag;
}
//************************************************************


public static Boolean sendEmailWithEmbeddedSignature(String messageText, String subject, String to, String resumePath, String gifPath) throws MessagingException {
    
    Boolean flag = false;
    String host = "smtp.gmail.com";
    String from = "dhaval.ajmera123456@gmail.com";  // Replace with your email
    String password = "duke dhjn xeqr hztb";  // Replace with your app password

    // Set up the properties for the SMTP connection
    Properties properties = System.getProperties();
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", "465");
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.auth", "true");

    // Create the session with an authenticator
    Session session = Session.getInstance(properties, new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(from, password);
        }
    });

    try {
        // Create a new email message
        MimeMessage m = new MimeMessage(session);
        m.setFrom(from);
        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        m.setSubject(subject);

        // Create the message body part for the text, using HTML format to reference the GIF
        MimeBodyPart textBodyPart = new MimeBodyPart();
        String htmlMessage = messageText + "<br>Best regards,<br><img src='cid:signature'>";
        textBodyPart.setContent(htmlMessage, "text/html");

        // Create the message body part for the resume attachment
        MimeBodyPart resumeBodyPart = new MimeBodyPart();
        resumeBodyPart.attachFile(new File(resumePath));

        // Create the message body part for the GIF (signature)
        MimeBodyPart gifBodyPart = new MimeBodyPart();
        gifBodyPart.attachFile(new File(gifPath));
        gifBodyPart.setContentID("<signature>"); // This content ID must match the "cid" in the HTML message
        gifBodyPart.setDisposition(MimeBodyPart.INLINE); // Ensure it's inline, not as a separate attachment

        // Create a multipart container for text, resume, and GIF parts
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(textBodyPart);        // Add text part with embedded GIF reference
        multipart.addBodyPart(resumeBodyPart);      // Add resume as attachment
        multipart.addBodyPart(gifBodyPart);         // Add GIF as embedded image

        // Set the multipart content to the message
        m.setContent(multipart);

        // Send the email
        Transport.send(m);
        System.out.println("Email with embedded GIF and resume attachment sent successfully...");
        
        flag = true;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return flag;
}

}
