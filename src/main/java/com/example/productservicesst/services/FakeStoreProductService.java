package com.example.productservicesst.services;

import com.example.productservicesst.dtos.FakeStoreProductDto;
import com.example.productservicesst.models.Category;
import com.example.productservicesst.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public  Product getProductById(Long id){
        throw new RuntimeException("Something went wrong.");
//        RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDto fakeStoreProductDto =
//                restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
//
//        if(fakeStoreProductDto == null){
//            return null;
//        }
//
//
//        //convert fakeStoreDto object to product object
//        Product product = new Product();
//        product.setId(fakeStoreProductDto.getId());
//        product.setTitle(fakeStoreProductDto.getTitle());
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setImage(fakeStoreProductDto.getImage());
//
//        Category category = new Category();
//        product.setDescription(fakeStoreProductDto.getDescription());
//        product.setCategory(category);
//
//        return product;

    }
    public List<Product> getAllProducts(){
        RestTemplate restTemplate = new RestTemplate();
        FakeStoreProductDto[] fakeStoreProductDtos =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                        FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
        }
        return products;

    }
    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setCategory(category);
        return product;

    }
}

