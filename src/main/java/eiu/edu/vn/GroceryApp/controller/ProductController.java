package eiu.edu.vn.GroceryApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import eiu.edu.vn.GroceryApp.model.Product;
import eiu.edu.vn.GroceryApp.service.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public String list(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null && !keyword.isEmpty())
            model.addAttribute("products", service.search(keyword));
        else {
            model.addAttribute("title", "Product Management");
            model.addAttribute("products", service.getAll());
        }

        model.addAttribute("categories", categoryService.getAll());

        return "products";
    }

    @PostMapping("/save")
    public String save(Product product) {
        service.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/products";
    }
}