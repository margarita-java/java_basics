package com.example.springbootapplication.DTO;

import java.time.Instant;

public class NewsDTO {

    private Long id;
    private String title;
    private String text;
    private Instant date;
    private String category;

    public NewsDTO() {}

    public NewsDTO(Long id, String title, String text, Instant date, String category) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}