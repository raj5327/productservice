package com.scaler.productservice.services;

import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {

    public Product getProductDetails (Long id);

    public Product createProduct(String title, String description, String image, double price, String category);  // To keep this method of Product service a generic one parameters are passed as arguments

    public List<Product> getAllProducts();
}
