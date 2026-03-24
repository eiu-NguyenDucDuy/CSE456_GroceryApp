package eiu.edu.vn.GroceryApp.repository;

import eiu.edu.vn.GroceryApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByNameContainingIgnoreCase(String keyword);
}