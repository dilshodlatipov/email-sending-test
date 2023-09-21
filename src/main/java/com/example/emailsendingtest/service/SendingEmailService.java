package com.example.emailsendingtest.service;

import com.example.emailsendingtest.payload.EmailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendingEmailService {
    private final MailSender mailSender;

    public Boolean sendEmail(EmailDTO emailDTO) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailDTO.getFrom());
        simpleMailMessage.setTo(emailDTO.getToWhom());
        simpleMailMessage.setSubject(emailDTO.getSubject());
        simpleMailMessage.setText(emailDTO.getText());

        mailSender.send(simpleMailMessage);
        System.out.println("Message send");
        return true;
    }
}