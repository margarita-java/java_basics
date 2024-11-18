package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class EmailNotification implements Notification {

    private String message; // сообщение
    private String subject; // тема сообщения
    private List<String> recipients; // список адресов получателей


    @Override
    public String formattedMessage() {
        return "<p>" + message + "</p>";
    }

}
