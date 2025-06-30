# 🧠 SQL + Hibernate Practice / Практика SQL и Hibernate

> Two Java console applications that work with MySQL database using JDBC and Hibernate.  
> Два Java-приложения, которые работают с базой данных MySQL с помощью JDBC и Hibernate.
---

## 📘 Task 1: Average Course Purchases (SQL + JDBC)
📗 Задание 1: Среднее количество покупок курса (SQL + JDBC)

### ✅ Goal / Цель
- Подключение к базе данных MySQL через JDBC
- Выполнение SQL-запроса
- Расчёт среднего количества покупок курса в месяц за 2018 год

### 🧩 Features / Особенности
- Используется таблица PurchaseList
- Учитывается период продаж по месяцам
- SQL-функция: MONTH(subscription_date)

### 🛠 Technologies / Технологии
- Java 17
- JDBC
- MySQL
- IntelliJ IDEA

### ▶️ Example Output / Пример вывода
Курс: Веб-разработчик с 0 до PRO
Продажи: 6
Период: Январь–Август
Среднее количество покупок: 0.75

---

## 📘 Task 2: Hibernate Entity Mapping + Composite Key
📗 Задание 2: Работа с Hibernate и составным ключом

### ✅ Goal / Цель
- Подключить Hibernate к Java-проекту
- Создать классы @Entity для всех таблиц
- Прописать связи между сущностями
- Заполнить таблицы из дампа
- Создать таблицу LinkedPurchaseList со составным ключом

### 📦 Database Entities / Сущности
- Student
- Course
- PurchaseList (readonly)
- LinkedPurchaseList (составной ключ `student_id + course_id`)
- SubscriptionKey — вспомогательный класс для composite key

### 🔐 Composite Key / Составной ключ
```java
@Embeddable
public class SubscriptionKey implements Serializable {
    private int studentId;
    private int courseId;
}
@Entity
public class Subscription {
    @EmbeddedId
    private SubscriptionKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;
}

---

### 🛠 Technologies / Технологии
Java 17
Hibernate ORM
MySQL
Maven + Hibernate + MySQL Connector
IntelliJ IDEA

---

### 🧩 Result / Результат
📊 Программа на SQL: анализирует покупки по курсам
🧱 Программа на Hibernate: строит таблицы из Entity, связывает их, создаёт таблицу LinkedPurchaseList
✅ Все задания протестированы, таблицы созданы и заполнены

‍💻 Author / Автор
Маргарита Арюткина