package com.scaler.productservice.controllers;


import com.scaler.productservice.dtos.CreateProductRequestDto;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.FakeStoreProductService;
import com.scaler.productservice.services.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

//@Component - RestContoller already comprises @Component internally. @Component creates the object
              //RestController also says the reader of code that whatever API's are there in the system are present in the class that is annotated by @RestController

public class ProductController {

    //ProductService productservice = new FakeStoreProductService();  this object creation is also taken care by @Restcontroller

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }


    //@RequestMapping
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public Product getProductDetails(@PathVariable("id") Long id){

        // the controller fetches the req java data from backend. But it cant return the java data.
        // so it is returned as json. Spring will take care of java to json(jackson) conversion
        // we can simply return in java


        // if there is any sensitive information needed to be hidden , we will use special classes called
        // dto classes.


        return productService.getProductDetails(id);


    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductRequestDto requestDto){


            Product product = productService.createProduct(
                requestDto.getTitle(),
                requestDto.getDescription(),
                requestDto.getImage(),
                requestDto.getPrice(),
                requestDto.getCategory()
        );

        ResponseEntity<Product> responseEntity = new ResponseEntity<>(product, HttpStatusCode.valueOf(201));

        return responseEntity;

    }

}
