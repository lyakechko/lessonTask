package com.example.lesson;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static ServiceSender target;
    public static ServiceSender proxy;

    public static void init() {
        target = new ServiceSender();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageSniffer());
        proxyFactory.setTarget(target);
        proxy = (ServiceSender) proxyFactory.getProxy();
    }

    public static void process(Message message) {
        target.sendMessage(message);
    }

    public static void proxyProcess(Message message) {
        proxy.sendMessage(message);
    }

    public static void main(String[] args) {
        //Задание 1
        ClassPathXmlApplicationContext annotationConfigApplicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");
        ServiceSender serviceSender = (ServiceSender) annotationConfigApplicationContext.getBean("serviceSender");
        serviceSender.sendMessage(Message.builder().text("Задание 1").build());

        System.out.println("--------------------------------------------------------------------------------------------------");
        //Задание 2
        init();
        proxyProcess(Message.builder().text("Моё сообщение...").build());
        process(Message.builder().text("Моё сообщение...").build());


    }
}
