package com.anthilgroup.anthilgroupwebsite.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anthilgroup.anthilgroupwebsite.mail.dto.EnquiryDTO;
import com.anthilgroup.anthilgroupwebsite.mail.service.IEmailService;

@RestController
@RequestMapping("/api/enquiry")
public class EnquiryController {

    @Autowired
    private IEmailService emailServiceImpl;

    @PostMapping("/send")
    public String sendEnquiry(@RequestBody EnquiryDTO dto) {
    	emailServiceImpl.sendEnquiryMail(dto);
        return "Enquiry sent successfully!";
    }
}