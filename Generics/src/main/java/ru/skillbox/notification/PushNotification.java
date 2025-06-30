package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public class PushNotification implements Notification {

    private String message;
    @Getter
    private String title;
    @Getter
    private String receiver;

    @Override
    public String formattedMessage() {
        return "\ud83d\udc4b" + message;
    }

}
