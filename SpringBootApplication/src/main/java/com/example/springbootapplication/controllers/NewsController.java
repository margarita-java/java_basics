package com.example.springbootapplication.controllers;

import com.example.springbootapplication.News;
import com.example.springbootapplication.service.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {  // исправил название конструктора
        this.newsService = newsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id) {
        Optional<News> news = newsService.getById(id);
        return news.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("message", "Новость с ID " + id + " не найдена.")));
    }
    @GetMapping
    public ResponseEntity<Collection<News>> getAll() {
        return ResponseEntity.ok(newsService.getAll());
    }

    @PostMapping
    public ResponseEntity<News> create(@RequestBody News news) {
        News createdNews = newsService.create(news);
        return ResponseEntity.status(201).body(createdNews);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody News news) {
        Optional<News> updatedNews = newsService.update(news);
        return updatedNews.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("message", "Новость с ID " + news.getId() + " не найдена.")));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (newsService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).body(Map.of("message", "Новость с ID " + id + " не найдена."));
        }
    }
}
