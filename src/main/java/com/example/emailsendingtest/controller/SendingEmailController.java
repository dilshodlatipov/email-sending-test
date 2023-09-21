package com.example.emailsendingtest.controller;

import com.example.emailsendingtest.payload.EmailDTO;
import com.example.emailsendingtest.service.SendingEmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class SendingEmailController {
    private final SendingEmailService sendingEmailService;

    @PostMapping("/send")
    public Boolean sendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        return sendingEmailService.sendEmail(emailDTO);
    }
}