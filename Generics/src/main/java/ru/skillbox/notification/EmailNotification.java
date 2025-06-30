package ru.skillbox.notification;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@Getter
@AllArgsConstructor
public class EmailNotification implements Notification {

    private String message;
    private String subject;
    private List<String> recipients;


    @Override
    public String formattedMessage() {
        return "<p>" + message + "</p>";
    }

}
