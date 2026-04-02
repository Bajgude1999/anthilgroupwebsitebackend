package com.anthilgroup.anthilgroupwebsite.mail.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.anthilgroup.anthilgroupwebsite.mail.dto.EnquiryDTO;
import com.anthilgroup.anthilgroupwebsite.mail.service.IEmailService;

import jakarta.mail.internet.MimeMessage;
@Service("emailServiceImpl")
public class EmailServiceImpl implements IEmailService{
	
	    @Autowired
	    private JavaMailSender mailSender;

	    public void sendEnquiryMail(EnquiryDTO dto) {
	        try {
	            MimeMessage message = mailSender.createMimeMessage();

	            MimeMessageHelper helper = new MimeMessageHelper(message, true);

	            // ✅ Dynamic subject
	            String subject = dto.getFullName() + " - " + dto.getInterestedIn();

	            helper.setSubject(subject);

	            // ✅ Receiver (change as per your need)
	            helper.setTo("info.anthillgroup@gmail.com");

	            // ✅ Sender (must be your SMTP email)
	            helper.setFrom("noreply.anthillgroup@gmail.com");

	            // ✅ User email (important for reply)
	            helper.setReplyTo(dto.getEmail());

	            // ✅ Mail body
	            String body =
	                    "New Enquiry Received\n\n" +
	                    "Full Name: " + dto.getFullName() + "\n" +
	                    "Phone: " + dto.getPhone() + "\n" +
	                    "Email: " + dto.getEmail() + "\n" +
	                    "Interested In: " + dto.getInterestedIn() + "\n\n" +
	                    "Message:\n" + dto.getMessage();

	            helper.setText(body);

	            mailSender.send(message);

	        } catch (Exception e) {
	            throw new RuntimeException("Failed to send email", e);
	        }
	    }
	}
