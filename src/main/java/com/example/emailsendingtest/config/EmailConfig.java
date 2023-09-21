package com.example.emailsendingtest.config;

import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class EmailConfig {
    @Value(value = "classpath:application.yml")
    private Properties properties;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.port}")
    private String port;
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Bean
    public MailSender mailSender() throws IOException {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(host);
        javaMailSender.setPort(Integer.parseInt(port));
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        javaMailSender.setJavaMailProperties(properties);
        javaMailSender.setSession(Session.getInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(javaMailSender.getUsername(), javaMailSender.getPassword());
                    }
                }));
        return javaMailSender;
    }
}
