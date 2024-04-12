package com.example.productservicesst.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Long Id;
    private String title;
    private String description;
    private double price;
    private Category Category;
    private String image;

    public Product() {

    }
}