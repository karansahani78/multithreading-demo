package com.karan.multithreading_demo.controller;

import com.karan.multithreading_demo.service.AsyncEmailService;
import com.karan.multithreading_demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @Autowired
    private AsyncEmailService asyncEmailService;

    // Synchronous call - blocks the request
    @GetMapping("/sync")
    public String sendEmailSync(String recipient) {
        return emailService.sendEmail(recipient);
    }
    // Asynchronous call - returns immediately
    @GetMapping("/async")
    public String sendEmailAsync(String recipient) {
        return asyncEmailService.sendEmailAsync(recipient).join();
    }
}
