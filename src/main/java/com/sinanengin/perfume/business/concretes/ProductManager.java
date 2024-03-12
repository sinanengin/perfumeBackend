package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.core.utilities.results.*;
import com.sinanengin.perfume.dataAccess.abstracts.ProductDao;
import com.sinanengin.perfume.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId) {

        return new SuccessDataResult<>(productDao.findProduct(volumeId, brandId, categoryId, genderId));
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<>(productDao.getByProductNameContains(productName));
    }

    @Override
    public DataResult<List<Product>> getByProductIsBestSeller() {
        return new SuccessDataResult<>(productDao.getByProductIsBestSeller(true));
    }

    @Override
    public Result addProduct(Product product) {
        if (productDao.findById(product.getProductId()).isPresent())
            return new ErrorResult("Bu ürün zaten kayıtlı!");
        productDao.save(product);
        return new SuccessResult("Ürün başarıyla eklendi.");
    }

    @Override
    public Result deleteProduct(int productId) {
        if (productDao.findById(productId).isEmpty())
            return new ErrorResult("Silmek istediğiniz ürün bulunamadı!");
        productDao.deleteById(productId);
        return new SuccessResult("Ürün başarıyla silindi.");
    }

    @Override
    public Result updateProduct(Product product) {
        if (productDao.findById(product.getProductId()).isEmpty())
            return new ErrorResult("Güncellemek istediğiniz ürün bulunamadı.");
        productDao.save(product);
        return new SuccessResult("Ürün başarıyla güncellendi.");
    }
}
