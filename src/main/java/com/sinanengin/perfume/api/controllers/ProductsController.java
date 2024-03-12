package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.Product;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
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
    public DataResult<List<Product>> getAll(@RequestParam(value = "volumeId",required = false)Integer volumeId,
                                 @RequestParam(value = "brandId",required = false)Integer brandId,
                                 @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                 @RequestParam(value = "genderId",required = false)Integer genderId

                                ) {


        return productService.getAll(volumeId, brandId, categoryId, genderId);

    }

    @GetMapping("/bestseller")
    public DataResult<List<Product>> getByProductIsBestSeller(){
        return productService.getByProductIsBestSeller();
    }

    @PostMapping
    public Result addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping
    public Result deleteProduct(@RequestParam int productId){
        return productService.deleteProduct(productId);
    }

    @PutMapping
    public Result updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }



}
