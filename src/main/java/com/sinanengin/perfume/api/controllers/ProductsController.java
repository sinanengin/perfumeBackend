package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(@RequestParam(value = "volumeId",required = false)Integer volumeId,
                                 @RequestParam(value = "brandId",required = false)Integer brandId,
                                 @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                 @RequestParam(value = "genderId",required = false)Integer genderId

                                ) {



        List<Product> productList = productService.getAll(volumeId, brandId,categoryId,genderId);
        return new ResponseEntity<List<Product>>(productList, HttpStatus.ACCEPTED);
    }


}
