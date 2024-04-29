package com.sinanengin.perfume.api.controllers;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.core.utilities.requests.PagedList;
import com.sinanengin.perfume.core.utilities.results.DataResult;
import com.sinanengin.perfume.core.utilities.results.Result;
import com.sinanengin.perfume.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductsController {

    ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public DataResult<PagedList<Product>> getAll(@RequestParam(value = "volumeId",required = false)Integer volumeId,
                                 @RequestParam(value = "brandId",required = false)Integer brandId,
                                 @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                 @RequestParam(value = "genderId",required = false)Integer genderId,
                                            @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer pageSize,
                                            @RequestParam(value = "pageNo", required = false, defaultValue = "0")Integer pageNo

                                ) {


        return productService.getAll(volumeId, brandId, categoryId, genderId,pageSize,pageNo);

    }

    @GetMapping("/bestseller")
    public DataResult<PagedList<Product>> getByProductIsBestSeller(@RequestParam(value = "pageSize", required = false, defaultValue = "20")Integer pageSize,
                                                                   @RequestParam(value = "pageNo", required = false, defaultValue = "0")Integer pageNo){
        return productService.getByProductIsBestSeller(pageSize, pageNo);
    }

    @GetMapping("/search/{keyword}")
    public DataResult<PagedList<Product>> searchProduct(@PathVariable String keyword,
                                                        @RequestParam(value = "pageSize", required = false, defaultValue = "10")Integer pageSize,
                                                        @RequestParam(value = "pageNo", required = false, defaultValue = "0")Integer pageNo){
        return productService.getByProductNameContains(keyword, pageSize, pageNo);
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
