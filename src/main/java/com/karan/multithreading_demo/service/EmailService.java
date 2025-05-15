package com.karan.multithreading_demo.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public String sendEmail(String recipient){
 try {
     Thread.sleep(300);
 } catch (InterruptedException e) {
     Thread.currentThread().interrupt();
 }
        return "Email sent to " + recipient + " by " + Thread.currentThread().getName();
    }
}
