package com.example.productservicesst.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long Id;
    private String Title;
    private double price;
    private String Category;
    private String description;
    private String image;

}
