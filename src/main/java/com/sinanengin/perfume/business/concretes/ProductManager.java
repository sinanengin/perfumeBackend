package com.sinanengin.perfume.business.concretes;

import com.sinanengin.perfume.business.abstracts.ProductService;
import com.sinanengin.perfume.core.utilities.requests.PagedList;
import com.sinanengin.perfume.core.utilities.results.*;
import com.sinanengin.perfume.dataAccess.abstracts.ProductDao;
import com.sinanengin.perfume.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public DataResult<PagedList<Product>> getAll(Integer volumeId, Integer brandId, Integer categoryId, Integer genderId, Integer pageSize, Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productDao.findAllWithFilters(volumeId, brandId, categoryId,genderId,pageable);
        PagedList<Product> pagedList = new PagedList<>();
        pagedList.setContent(products.getContent());
        pagedList.setPageSize(products.getSize());
        pagedList.setTotalPage(products.getTotalPages());
        pagedList.setTotalCount((int) products.getTotalElements());
        pagedList.setHasNext(products.hasNext());
        pagedList.setHasPrevious(products.hasPrevious());
        pagedList.setCurrentPage(pageNo);

        return new SuccessDataResult<>(pagedList);
    }

    @Override
    public DataResult<PagedList<Product>> getByProductNameContains(String productName, Integer pageSize, Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productDao.getByProductNameContains(productName, pageable);
        PagedList<Product> pagedList = new PagedList<>();
        pagedList.setContent(products.getContent());
        pagedList.setPageSize(products.getSize());
        pagedList.setTotalPage(products.getTotalPages());
        pagedList.setTotalCount((int) products.getTotalElements());
        pagedList.setHasNext(products.hasNext());
        pagedList.setHasPrevious(products.hasPrevious());
        pagedList.setCurrentPage(pageNo);

        return new SuccessDataResult<>(pagedList);
    }

    @Override
    public DataResult<PagedList<Product>> getByProductIsBestSeller(Integer pageSize, Integer pageNo) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Product> products = productDao.getByProductIsBestSeller(
                true, pageable);
        PagedList<Product> pagedList = new PagedList<>();
        pagedList.setContent(products.getContent());
        pagedList.setPageSize(products.getSize());
        pagedList.setTotalPage(products.getTotalPages());
        pagedList.setTotalCount((int) products.getTotalElements());
        pagedList.setHasNext(products.hasNext());
        pagedList.setHasPrevious(products.hasPrevious());
        pagedList.setCurrentPage(pageNo);

        return new SuccessDataResult<>(pagedList);


    }

    @Override
    public DataResult<Product> addProduct(Product product) {
        if (productDao.findById(product.getProductId()).isPresent())
            return new ErrorDataResult<>("Bu ürün zaten kayıtlı!");

        productDao.save(product);
        return new SuccessDataResult<>(product,"Ürün başarıyla eklendi.");
    }

    @Override
    public DataResult<Product> deleteProduct(int productId) {
        if (productDao.findById(productId).isEmpty())
            return new ErrorDataResult<>("Silmek istediğiniz ürün bulunamadı!");
        productDao.deleteById(productId);
        return new SuccessDataResult<>("Ürün başarıyla silindi.");
    }

    @Override
    public DataResult<Product> updateProduct(Product product) {
        if (productDao.findById(product.getProductId()).isEmpty())
            return new ErrorDataResult<>("Güncellemek istediğiniz ürün bulunamadı.");
        productDao.save(product);
        return new SuccessDataResult<>(product,"Ürün başarıyla güncellendi.");
    }
}
