package com.sendemail.senderemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SenderemailApplication {
	@Autowired
	private static EmailSender sender;


	public static void main(String[] args) {
		SpringApplication.run(SenderemailApplication.class, args);
	}



	public static void sendMail(String target_email, String targetSubject, String text) {
		sender.sendEmail(target_email, targetSubject, text);
	}
}
