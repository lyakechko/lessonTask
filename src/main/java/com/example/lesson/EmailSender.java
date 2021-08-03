package com.example.lesson;

import java.util.Objects;

public class EmailSender implements ISender {
    @Override
    public void sendMessage(Message message) {
        System.out.println("Ваше сообщение отправлено: ");
        if (Objects.nonNull(message)) {
            System.out.println(message.getText());
        } else {
            System.out.println("отсутвует тело сообщения");
        }
    }

    public void sendMessageTask2(Message message) {
        System.out.println("Ваше сообщение отправлено: ");
        if (Objects.nonNull(message)) {
            System.out.println(message.getText());
        } else {
            System.out.println("отсутвует тело сообщения");
        }
    }
}
