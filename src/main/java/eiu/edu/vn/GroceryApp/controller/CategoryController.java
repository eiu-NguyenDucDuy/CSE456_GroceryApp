package eiu.edu.vn.GroceryApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import eiu.edu.vn.GroceryApp.model.Category;
import eiu.edu.vn.GroceryApp.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null) model.addAttribute("categories", service.search(keyword));
        else {
            model.addAttribute("title", "Category Management");
            model.addAttribute("categories", service.getAll());
        }

        return "categories";
    }

    @PostMapping("/save")
    public String save(Category category) {
        service.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/categories";
    }
}