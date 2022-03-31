package com.project3.revtech.service;

import javax.transaction.Transactional;

import com.project3.revtech.dao.ProductRepository;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.ProductPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImpl(){}

    @Override
    public ProductPojo addProductService(ProductPojo productPojo) throws ApplicationException {
      ProductEntity  newProduct= null;
        newProduct = new  ProductEntity(
                productPojo.getProductId(), productPojo.getProductSku(),
                productPojo.getProductName(), productPojo.getProductCost(),
                productPojo.getProductCategory(), productPojo.getProductDescription(),
                productPojo.getProductQty(), productPojo.getImageUrl(),
                productPojo.isProductRemoved());
        //Entity Product object
        ProductEntity returnProduct = productRepository.saveAndFlush(newProduct);
        productPojo.setProductId(returnProduct.getProductId());
        return productPojo;
    }

    @Override
    public ProductPojo updateProductService(ProductPojo productPojo) throws ApplicationException {
         ProductEntity updateProduct = new  ProductEntity(
                productPojo.getProductId(), productPojo.getProductSku(),
                productPojo.getProductName(), productPojo.getProductCost(),
                productPojo.getProductCategory(), productPojo.getProductDescription(),
                productPojo.getProductQty(), productPojo.getImageUrl(),
                productPojo.isProductRemoved());
        //Entity Product object
        ProductEntity returnProduct = productRepository.save(updateProduct);
        return productPojo;
    }
    @Override
    public boolean deleteProductService(int productId) throws ApplicationException {
        this.productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductPojo getAProductService(int productId) throws ApplicationException {
        ProductPojo productPojo = null;
        Optional<ProductEntity> optional = this.productRepository.findById(productId);
        if (optional.isPresent()) {
            ProductEntity product = optional.get();
            productPojo = new  ProductPojo(product.getProductId(), product.getProductSku(),
                    product.getProductName(), product.getProductCost(),
                    product.getProductCategory(), product.getProductDescription(),
                    product.getProductQty(), product.getImageUrl(),
                    product.isProductRemoved());
        }
        return  productPojo;
    }

    @Override
    public List<ProductPojo> getAllProductService() throws ApplicationException {
        List<ProductEntity> allProductEntity = this.productRepository.findAll();
        List<ProductPojo> allProductPojo = new ArrayList<>();
        allProductEntity.forEach((product) -> {
           ProductPojo productPojo = new  ProductPojo(product.getProductId(), product.getProductSku(),
                    product.getProductName(), product.getProductCost(),
                    product.getProductCategory(), product.getProductDescription(),
                    product.getProductQty(), product.getImageUrl(),
                    product.isProductRemoved());
           allProductPojo.add(productPojo);
        });
        return allProductPojo;
    }

    //------------Will add more custom methods below later if needed
    @Override
    public ProductPojo getADiscountProductService(int productId) throws ApplicationException {
        ProductPojo productPojo = null;
        Optional<ProductEntity> optional = this.productRepository.findById(productId);
        if (optional.isPresent()) {
            ProductEntity product = optional.get();
            productPojo = new  ProductPojo(product.getProductId(), product.getProductSku(),
                    product.getProductName(), product.getProductCost(),
                    product.getProductCategory(), product.getProductDescription(),
                    product.getProductQty(), product.getImageUrl(),
                    product.isProductRemoved());
        }
        return  productPojo;
    }

    @Override
    public List<ProductPojo> getAllDiscountProductService() throws ApplicationException {
        List<ProductEntity> allProductEntity = this.productRepository.findAll();
        List<ProductPojo> allProductPojo = new ArrayList<>();
        allProductEntity.forEach((product) -> {
            ProductPojo productPojo = new  ProductPojo(product.getProductId(), product.getProductSku(),
                    product.getProductName(), product.getProductCost(),
                    product.getProductCategory(), product.getProductDescription(),
                    product.getProductQty(), product.getImageUrl(),
                    product.isProductRemoved());
            allProductPojo.add(productPojo);
        });
        return allProductPojo;
    }
    
}
