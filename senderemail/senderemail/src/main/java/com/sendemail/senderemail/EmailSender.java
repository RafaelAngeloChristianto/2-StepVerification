package com.sendemail.senderemail;

import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;


@Service
public class EmailSender {
    @Autowired
    public JavaMailSender email_sendder;


    // email credentials
    public void sendEmail(String targetEmail, String subjectEmail, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("angelorafael0508@gmail.com");
        message.setTo(targetEmail);
        message.setSubject(subjectEmail);
        message.setText(text);
        email_sendder.send(message);
    }
}
