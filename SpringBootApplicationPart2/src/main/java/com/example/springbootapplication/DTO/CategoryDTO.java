package com.example.springbootapplication.DTO;

public class CategoryDTO {

    private Long id;
    private String title;

    public CategoryDTO() {

    }

    public CategoryDTO(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
