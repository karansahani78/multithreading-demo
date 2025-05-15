package com.karan.multithreading_demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
public class AsyncEmailService {
    // Executes this method asynchronously in a separate thread
    @Async
    public CompletableFuture<String> sendEmailAsync(String recipient) {
        try {
            Thread.sleep(3000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String result = "Async email sent to " + recipient + " by " + Thread.currentThread().getName();
        return CompletableFuture.completedFuture(result);
    }
}
