package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class PushNotification implements Notification {

    private String message; // сообщение
    @Getter
    private String title; // заголовок
    @Getter
    private String receiver; // аккаунт

    @Override
    public String formattedMessage() {
        return "\ud83d\udc4b" + message;
    }

}
