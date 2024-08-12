package com.asarit.amzon.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    private String description;
    private Double price;
    private Integer stock;

    public Product(String sku, String description, Double price, Integer stock) {
        this.sku=sku;
        this.description=description;
        this.price=price;
        this.stock=stock;
    }
}
