package com.example.springbootapplication.servise;

import com.example.springbootapplication.DTO.NewsDTO;
import com.example.springbootapplication.models.News;
import com.example.springbootapplication.repositories.NewsRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public Optional<News> getById(Long id) {
        return newsRepository.findById(id);
    }

    public List<News> getAll() {
        return newsRepository.findAll();
    }

    public News create(News news) {
        news.setDate(Instant.now());
        return newsRepository.save(news);
    }

    public Optional<News> update(News updatedNews) {
        if (!newsRepository.existsById(updatedNews.getId())) {
            return Optional.empty();
        }
        updatedNews.setDate(Instant.now());
        return Optional.of(newsRepository.save(updatedNews));
    }

    public boolean deleteById(Long id) {
        if (!newsRepository.existsById(id)) {
            return false;
        }
        newsRepository.deleteById(id);
        return true;
    }

    public List<NewsDTO> getByCategoryId(Long categoryId) {
        List<News> newsList = newsRepository.findByCategoryId(categoryId);
        return newsList.stream()
                .map(news -> new NewsDTO(
                        news.getId(),
                        news.getTitle(),
                        news.getText(),
                        news.getDate(),
                        news.getCategory().getTitle()
                ))
                .collect(Collectors.toList());
    }

}