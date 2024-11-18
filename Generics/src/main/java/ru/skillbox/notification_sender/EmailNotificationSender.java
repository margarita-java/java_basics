package ru.skillbox.notification_sender;
import ru.skillbox.notification.EmailNotification;

import java.util.List;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {

    @Override
    public void send (EmailNotification notification) {
        System.out.println(String.format ("EMAIL:\nsubject: %s\nreceivers: %s\nmessage: %s",
                notification.getSubject(), String.join(", ", notification.getRecipients()),
                notification.formattedMessage()));
    }

    @Override
    public void send (List<EmailNotification> notifications) {
        for (EmailNotification notification : notifications) {
            send(notification);
        }
    }

}
