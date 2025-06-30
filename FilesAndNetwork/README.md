# 🚇 Metro Data Parser / Парсер данных метро

📘 This project extracts and combines information about Moscow Metro lines and stations from a website and additional files (JSON and CSV), then saves it into structured JSON files.

📘 Этот проект извлекает и объединяет данные о линиях и станциях Московского метро с сайта и дополнительных файлов (JSON и CSV), а затем сохраняет их в структурированные JSON-файлы.

---

## 🎯 Purpose / Цель проекта

- 🧭 Learn how to parse HTML using Jsoup
- 🧩 Merge and structure data from multiple sources (web, JSON, CSV)
- 🧾 Generate clean and consistent JSON output using Gson
- 📊 Handle duplicate station names, transfer stations, depth, and opening dates

---

## 📁 Output files / Выходные файлы

The program creates two JSON files:

Программа создаёт два JSON-файла:

1. stations.json – JSON object with metro lines and their stations
2. stations-info.json – Array with detailed info about each station:
    - name – station name
    - line – line number
    - depth – optional (only if available)
    - date – optional (only if available)

⚠️ If a station doesn't have depth or date — the corresponding keys are excluded.

⚠️ Если для станции нет глубины или даты — соответствующих ключей не будет.

---

## ⚙️ Technologies / Используемые технологии

- Java 17
- Jsoup (HTML парсинг / parsing)
- Gson (JSON генерация)
- CSVReader
- IntelliJ IDEA

---

## 🚀 How to run / Как запустить

1. ✅ Install JDK 17+
2. 🔧 Open the project in IntelliJ IDEA
3. 📦 Make sure dependencies for Jsoup and Gson are added
4. ▶️ Run the main class (e.g., `MetroDataParser.java`)
5. 📁 Check the generated files: stations.json and stations-info.json

---

## 📦 Sample Output / Пример выходного JSON

### stations.json
```json
{
  "lines": [
    {
      "number": "1",
      "name": "Сокольническая",
      "stations": ["Бульвар Рокоссовского", "Черкизовская", ...]
    }
  ]
}
stations-info.json
[
  {
    "name": "Тверская",
    "line": "2",
    "depth": "-42",
    "date": "1979-11-20"
  }
]
👩‍💻 Author / Автор
Маргарита Арюткина