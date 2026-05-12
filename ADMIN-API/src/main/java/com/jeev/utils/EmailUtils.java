package com.jeev.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender jsm;

	public boolean sendEmail(String subject, String body, String to) {
		
		try {
			MimeMessage mmm = jsm.createMimeMessage();
			MimeMessageHelper mm = new MimeMessageHelper(mmm, true);
			mm.setFrom("jeevanraj1701@gmail.com");
			mm.setSubject(subject);
			mm.setText(body, true);
			mm.setTo(to);
			jsm.send(mmm);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

}

/*
 * package in.jeev.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtil {
	
	@Autowired
	private JavaMailSender jsm;
	
	public boolean sendEmail(String subject, String body, String to, File f) {
		try {
			MimeMessage mmm = jsm.createMimeMessage();
			MimeMessageHelper mm = new MimeMessageHelper(mmm, true);
			mm.setFrom("jeevanraj1701@gmail.com");
			mm.setSubject(subject);
			mm.setText(body, true);
			mm.setTo(to);
			mm.addAttachment("Plan-info", f);
			jsm.send(mmm);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}

 */