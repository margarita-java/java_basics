# 🧾 Console Customer List — Исключения и логгирование / Exceptions & Logging

📘 Проект представляет собой консольное приложение для хранения списка клиентов.  
Реализована обработка ошибок, создание собственных исключений и логгирование с использованием Log4j2.

---

## 🧩 Основные функции / Features

- 🧑 Добавление клиентов через команду add Иван Иванов ivan@example.com +79001234567
- 📃 Просмотр всех клиентов через list
- ❌ Обработка ошибок с пользовательскими исключениями:
    - Некорректный формат команды
    - Неверный формат email
    - Неверный формат телефона
- 🛑 Исключения не приводят к завершению программы — пользователь получает понятное сообщение

---

## 🪵 Логгирование / Logging

🔧 Используется библиотека Log4j2. Настроены два лога:

- 🟩 logs/queries.log — содержит информацию обо всех действиях пользователя
- 🟥 logs/errors.log — фиксирует все ошибки и исключения

Формат логов настраивается через log4j2.xml.

---

## 🛠️ Технологии

- Java 17
- Log4j2
- Custom Exceptions (`InvalidEmailException`, InvalidPhoneException, `WrongCommandFormatException`)
- Regular Expressions
- Maven

---

## 🚀 Как запустить

1. Установи Java 17+ и IntelliJ IDEA
2. Убедись, что зависимости Log4j2 подключены в pom.xml
3. Запусти Main и используй команды из help
4. Логи появятся в папке /logs

---

## 👩‍💻 Автор / Author

Маргарита Арюткина

---

# 🧾 Console Customer List — Exceptions & Logging

📘 This is a console-based Java application for storing and managing a list of customers.  
The project demonstrates error handling, custom exceptions, and logging with Log4j2.

---

## 🧩 Features

- 🧑 Add customers via add Ivan Ivanov ivan@example.com +79001234567
- 📃 List all customers using list
- ❌ Robust error handling with custom exceptions:
    - Invalid command format
    - Invalid email format
    - Invalid phone number format
- 🛑 Exceptions are caught and displayed in a user-friendly way — app doesn't crash

---

## 🪵 Logging

🔧 Powered by Log4j2 with two separate log files:

- 🟩 logs/queries.log — all user queries and commands
- 🟥 logs/errors.log — detailed error and exception logs

Configured via log4j2.xml.

---

## 🛠️ Technologies

- Java 17
- Log4j2
- Custom RuntimeExceptions
- Regular Expressions
- Maven

---

## 🚀 How to run

1. Install Java 17+ and IntelliJ IDEA
2. Ensure Log4j2 dependencies are in pom.xml
3. Run the Main class and interact via console
4. Check /logs folder for output

---

## 👩‍💻 Author

Margarita Aryutkina  
