package com.example.springbootapplication.repositories;

import com.example.springbootapplication.models.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findByCategoryId(Long categoryId);
}