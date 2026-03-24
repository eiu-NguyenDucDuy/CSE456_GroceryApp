package eiu.edu.vn.GroceryApp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eiu.edu.vn.GroceryApp.model.Product;
import eiu.edu.vn.GroceryApp.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getAll() {
        return repo.findAll();
    }

    public List<Product> search(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword);
    }

    public void save(Product product) {
        repo.save(product);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Product find(Long id) {
        return repo.findById(id).orElse(null);
    }

}