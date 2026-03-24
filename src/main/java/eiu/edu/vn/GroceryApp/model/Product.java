package eiu.edu.vn.GroceryApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    @NotNull
    @Size(min = 5, max = 100, message = "Length of name must be between 5 and 100.")
    private String name;

    @Column(nullable = false)
    @Min(value = 0, message = "Price must be at least 0.")
    private Double price;

    @Column(nullable = false)
    @Min(value = 0, message = "Quantity must be at least 0.")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product(String name, double price, int quantity, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }
}