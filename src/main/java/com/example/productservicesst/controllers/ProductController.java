package com.example.productservicesst.controllers;

import com.example.productservicesst.dtos.ExceptionDto;
import com.example.productservicesst.models.Product;
import com.example.productservicesst.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;


//localhost:8080/products -> ProductsController
@RestController
@RequestMapping("/products")
public class ProductController { //waiter

    private ProductService productService ;
    ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id){
        Product product = null;

        try{
            product = productService.getProductById(id);
            ResponseEntity<Product> responseEntity  = new ResponseEntity<>(product, HttpStatus.OK);
            return responseEntity;
        }catch (RuntimeException exception) {
            ExceptionDto dto = new ExceptionDto();
            dto.setMessage("Something went wrong");
            ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
            return response;
        }
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
