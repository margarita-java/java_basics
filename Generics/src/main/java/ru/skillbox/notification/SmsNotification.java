package ru.skillbox.notification;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;


@AllArgsConstructor
public class SmsNotification implements Notification {

    private String message;
    @Getter
    private List<String> phoneNumbers;


    @Override
    public String formattedMessage() {
        return message;
    }

}
