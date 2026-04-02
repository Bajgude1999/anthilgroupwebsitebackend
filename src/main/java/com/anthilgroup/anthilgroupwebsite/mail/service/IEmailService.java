package com.anthilgroup.anthilgroupwebsite.mail.service;

import com.anthilgroup.anthilgroupwebsite.mail.dto.EnquiryDTO;

public interface IEmailService {

	void sendEnquiryMail(EnquiryDTO dto);

}
