package ru.skillbox;

import ru.skillbox.notification.EmailNotification;
import ru.skillbox.notification.PushNotification;
import ru.skillbox.notification.SmsNotification;
import ru.skillbox.notification_sender.EmailNotificationSender;
import ru.skillbox.notification_sender.NotificationSender;
import ru.skillbox.notification_sender.PushNotificationSender;
import ru.skillbox.notification_sender.SmsNotificationSender;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Email Notification
        EmailNotification email = new EmailNotification(
                "Спасибо за регистрацию на сервисе!", "Успешная регистрация!",
                Arrays.asList("oleg@java.skillbox.ru", "masha@java.skillbox.ru", "yan@java.skillbox.ru")

        );
        NotificationSender<EmailNotification> emailSender = new EmailNotificationSender();
        emailSender.send(email);

        // SMS Notification
        SmsNotification sms = new SmsNotification(
                "Спасибо за регистрацию на сервисе!",
                Arrays.asList("+70001234567")

        );
        NotificationSender<SmsNotification> smsSender = new SmsNotificationSender();
        smsSender.send(sms);

        // Push Notification
        PushNotification push = new PushNotification(
                "Спасибо за регистрацию на сервисе!",
                "Успешная регистрация!",
                "o.yanovich"
        );
        NotificationSender<PushNotification> pushSender = new PushNotificationSender();
        pushSender.send(push);
    }
}
