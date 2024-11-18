package ru.skillbox.notification_sender;

import ru.skillbox.notification.PushNotification;

import java.util.List;

public class PushNotificationSender implements NotificationSender <PushNotification> {

    @Override
    public void send(PushNotification notification) {
        System.out.println(String.format(
                "PUSH:\ntitle: %s\nreceiver: %s\nmessage: %s",
                notification.getTitle(), notification.getReceiver(), notification.formattedMessage()
        ));
    }

    @Override
    public void send(List<PushNotification> notifications) {
        for (PushNotification notification : notifications) {
            send(notification);
        }
    }
}
