# 🔔 Java Notification Service

> Java project demonstrating notification architecture with generics, interfaces, and Lombok  
> 📘 Практическое задание по теме "Интерфейсы, дженерики и Lombok" в Java. Выполнено в рамках обучения на платформе Skillbox.

---

## 🧩 Задание / Task Overview

### 🇷🇺 На русском:

Программа имитирует систему отправки уведомлений пользователям через разные каналы связи. Уведомления реализованы в виде классов, каждый из которых:
- реализует интерфейс Notification,
- имеет свои поля и формат сообщения.

Типы уведомлений:
- 📧 EmailNotification — содержит тему, список email и оборачивает сообщение в теги <p>...</p>.
- 📱 SmsNotification — содержит список номеров, сообщение не форматируется.
- 📲 PushNotification — добавляет в начало текста 👋, содержит заголовок и аккаунт.

Каждое уведомление обрабатывается соответствующим сервисом (`NotificationSender<T>`), который умеет:
- отправлять одно уведомление,
- отправлять список уведомлений.

Также подключена библиотека Lombok, которая избавляет от шаблонного кода (геттеры, сеттеры, конструкторы).

---

### 🇬🇧 In English:

The program simulates sending notifications to users via different communication channels. Each notification:
- implements the Notification interface,
- includes specific fields and message formatting logic.

Notification types:
- 📧 EmailNotification — includes subject, recipients list, and wraps the message in <p>...</p>.
- 📱 SmsNotification — includes phone numbers, keeps the message plain.
- 📲 PushNotification — prepends 👋 emoji to the message, includes title and user account.

Each notification type has its own sender class implementing NotificationSender<T>:
- supports sending one or multiple notifications.

The project also uses Lombok to eliminate boilerplate code (getters, setters, constructors).

---

## 💬 Пример вывода / Output Example

EMAIL subject: Успешная регистрация! receivers: oleg@java.skillbox.ru, masha@java.skillbox.ru message: <p>Спасибо за регистрацию на сервисе!</p>
SMS receivers: +70001234567 message: Спасибо за регистрацию на сервисе!
PUSH title: Успешная регистрация! receiver: o.yanovich message: 👋 Спасибо за регистрацию на сервисе!

---

## 🛠 Технологии / Technologies

- Java 17
- Interfaces and Generics
- Collections (List)
- Lombok (`@Data`, @NoArgsConstructor, `@AllArgsConstructor`)
- IntelliJ IDEA
- Maven

---

## 📦 Зависимость Lombok / Lombok Dependency

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.30</version>
    <scope>provided</scope>
</dependency>
🚀 Как запустить / How to Run
Установите Java 17+ Install Java 17+
Убедитесь, что Lombok подключён в IDE Make sure Lombok is enabled in your IDE
Откройте проект в IntelliJ IDEA Open the project in IntelliJ IDEA
Запустите метод main() в классе Main Run the main() method in the Main class

👩‍💻 Автор / Author
Маргарита Арюткина