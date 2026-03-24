package eiu.edu.vn.GroceryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eiu.edu.vn.GroceryApp.model.Category;
import eiu.edu.vn.GroceryApp.repository.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public List<Category> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    public void save(Category category) {
        repo.save(category);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}