package com.example.springbootapplication.service;


import com.example.springbootapplication.News;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class NewsService {

    private final Map<Long, News> newsStorage = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Optional<News> getById(Long id) {
        return Optional.ofNullable(newsStorage.get(id));
    }

    public Collection<News> getAll() {
        return newsStorage.values();
    }

    public News create(News news) {
        Long id = idGenerator.getAndIncrement();
        news.setId(id);
        news.setDate(Instant.now());
        newsStorage.put(id, news);
        return news;
    }

    public Optional<News> update(News updatedNews) {
        if (!newsStorage.containsKey(updatedNews.getId())) {
            return Optional.empty();
        }
        updatedNews.setDate(Instant.now());
        newsStorage.put(updatedNews.getId(), updatedNews);
        return Optional.of(updatedNews);
    }

    public boolean deleteById(Long id) {
        return newsStorage.remove(id) != null;
    }
}
