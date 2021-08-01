package com.watch.switme.service;

import com.watch.switme.dto.SignUpDTO;
import com.watch.switme.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import javax.xml.crypto.dsig.SignedInfo;
import java.awt.*;

@RequiredArgsConstructor
@Transactional
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private UserRepository userRepository;


    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }
    public void sendMail(String email, String message)  throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        helper.setFrom("SWITME");
        helper.setTo(email);
        helper.setSubject("SWITME");
        helper.setText(message, true);
        javaMailSender.send(mimeMessage);
    }
}
