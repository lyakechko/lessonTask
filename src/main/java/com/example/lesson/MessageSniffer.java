package com.example.lesson;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MessageSniffer implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arg = methodInvocation.getArguments();
        Message message = (Message) arg[0];
        message.setText("Сообщение перехвачено");
        return methodInvocation.proceed();
    }
}
