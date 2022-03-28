package com.example.test.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
@AllArgsConstructor
public class EmailService  {

    JavaMailSender javaMailSender;

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

}


