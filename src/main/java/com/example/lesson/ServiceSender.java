package com.example.lesson;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class ServiceSender {

    private ISender sender;

    private EmailSender emailSender= new EmailSender();


    public ServiceSender() {
    }

    public ServiceSender(ISender sender) {
        this.sender = sender;
    }

    public void sendMessage(Message message) {
        emailSender.sendMessage(message);
    }

    public void setSender(ISender iSender) {
        this.sender = iSender;
    }
}
