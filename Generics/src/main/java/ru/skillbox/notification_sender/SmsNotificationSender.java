package ru.skillbox.notification_sender;

import ru.skillbox.notification.SmsNotification;

import java.util.List;

public class SmsNotificationSender implements NotificationSender<SmsNotification> {

    @Override
    public void send(SmsNotification notification) {
        System.out.println(String.format(
                "SMS:\nreceivers: %s\nmessage: %s",
                String.join(", ", notification.getPhoneNumbers()),
                notification.formattedMessage()
        ));
    }

    @Override
    public void send(List<SmsNotification> notifications) {
        for (SmsNotification notification : notifications) {
            send(notification); // Вызываем метод отправки для каждого уведомления
        }
    }
}
