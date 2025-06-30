# 📰 Spring Boot News App: PostgreSQL + Liquibase + JPA / Новости и Категории

> Расширенное REST API для управления новостями и категориями. Используется PostgreSQL как база данных, Liquibase — для миграций, Spring JPA — для работы с сущностями.  
> Extended REST API for managing news and categories. PostgreSQL is used as the database, Liquibase for database version control, and Spring JPA for entity management.

---

## 🎯 Цели / Goals

- ✅ Настроить приложение для работы с PostgreSQL
- ✅ Подключить Liquibase для миграций
- ✅ Перейти от ConcurrentHashMap к полноценной БД
- ✅ Создать связи между сущностями News и Category
- ✅ Реализовать API для управления новостями и категориями

---

## 🗃 Структура данных / Data Structure

### 🗞 News (Новость)

- id: Long
- title: String
- text: String
- date: Instant
- category: Category

### 🏷 Category (Категория)

- id: Long
- title: String

---

## 🧪 API Endpoints

### 📄 News API

| Method | Endpoint                        | Description                              |
|--------|----------------------------------|------------------------------------------|
| GET    | /api/news                     | Получить список всех новостей / Get all  |
| GET    | /api/news/{id}                | Получить новость по ID / Get by ID       |
| POST   | /api/news                     | Создать новость / Create news            |
| PUT    | /api/news                     | Обновить новость / Update news           |
| DELETE | /api/news/{id}                | Удалить новость / Delete by ID           |
| GET    | /api/news/category/{id}       | Новости по ID категории / By category    |

### 🏷 Category API

| Method | Endpoint                   | Description                             |
|--------|-----------------------------|-----------------------------------------|
| GET    | /api/categories          | Получить все категории / Get all        |
| GET    | /api/categories/{id}     | Получить категорию по ID / Get by ID    |
| POST   | /api/categories          | Создать категорию / Create category     |
| PUT    | /api/categories          | Обновить категорию / Update category    |
| DELETE | /api/categories/{id}     | Удалить категорию / Delete by ID        |

---

## 💾 Подключение к PostgreSQL / PostgreSQL Connection

application.properties
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/news_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=none
spring.liquibase.enabled=true
🧱 Liquibase
📁 Файлы миграций находятся в resources/db.
Создаются таблицы news и category, в таблице news — внешний ключ category_id.

🧰 Пример POST-запроса / Example POST request
Создание новости:
{
  "title": "Новая новость",
  "text": "Текст новости",
  "date": "2023-10-22T14:45:00Z",
  "category": "Нейросети"
}
Создание категории:
{
  "title": "Web-разработка"
}
👩‍💻 Автор / Author
Маргарита Арюткина