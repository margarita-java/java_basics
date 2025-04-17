package com.example.springbootapplication.servise;

import com.example.springbootapplication.DTO.CategoryDTO;
import com.example.springbootapplication.models.Category;
import com.example.springbootapplication.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Optional<Category> updateCategory(Long id, Category categoryDetails) {
        return categoryRepository.findById(id).map(category -> {
            category.setTitle(categoryDetails.getTitle());
            return categoryRepository.save(category);
        });
    }

    public boolean deleteCategory(Long id) {
        return categoryRepository.findById(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
    }

    public CategoryDTO toCategoryDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getTitle());
    }

    public Category toCategory(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.getId(), categoryDTO.getTitle());
    }
}

