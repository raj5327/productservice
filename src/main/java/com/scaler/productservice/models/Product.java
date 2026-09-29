package com.scaler.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter // Getter and Setter are obtained from lombok. getter & setter prevents writing POST/GET/PUT Code lines for all the attributes of the product which are more in number
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private Category category;
}


