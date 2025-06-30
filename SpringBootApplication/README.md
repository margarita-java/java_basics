# 📰 Spring Boot: News REST API / Новости через REST API на Spring Boot

> Простое веб-приложение с REST API для управления новостями. Реализовано на Java с использованием Spring Boot и хранением данных в ConcurrentHashMap.  
> A simple Spring Boot web application with a REST API for managing news items. Uses ConcurrentHashMap as the in-memory data store.

---

## 🎯 Goal / Цель

- Освоить работу с REST-контроллерами в Spring Boot.
- Научиться создавать, получать, редактировать и удалять данные через API.
- Использовать ConcurrentHashMap как хранилище новостей без подключения к БД.

---

## 🧩 Features / Особенности

✅ CRUD API:
- GET /api/news — получить список всех новостей
- GET /api/news/{id} — получить новость по ID
- POST /api/news — создать новость
- PUT /api/news — обновить новость
- DELETE /api/news/{id} — удалить новость

📦 Данные сохраняются в памяти через ConcurrentHashMap.

⏱ Каждая новость содержит:
- id: уникальный идентификатор (Long)
- title: заголовок (String)
- text: текст (String)
- date: дата публикации (Instant)

---

## 🧪 Example JSON / Пример запроса и ответа

POST /api/news
```json
{
  "titl
Ответ (201 Created)
{
  "id": 1,
  "title": "Новая новость",
  "text": "Это первая новость",
  "date": "2023-10-20T12:00:00Z"
}
GET /api/news/1
{
  "id": 1,
  "title": "Новая новость",
  "text": "Это первая новость",
  "date": "2023-10-20T12:00:00Z"
}
Ошибка (404 Not Found)
{
  "message": "Новость с ID 5 не найдена."
}
👩‍💻 Author / Автор
Маргарита Арюткина