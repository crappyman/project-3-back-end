package com.project3.revtech.service;

import com.project3.revtech.dao.PurchasedItemRepository;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.PurchasedItemEntity;
import com.project3.revtech.joinedpojo.PurchasedItemProduct;
import com.project3.revtech.pojo.ProductPojo;
import com.project3.revtech.pojo.PurchasedItemPojo;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PurchasedItemServiceImpl implements PurchasedItemService{

    @Autowired
    PurchasedItemRepository purchasedItemRepository;

    @Override
    public PurchasedItemPojo addItem(PurchasedItemPojo item) {
        PurchasedItemEntity newItemEntity = new PurchasedItemEntity(  item.getTransactionId(), item.getUserId(), item.getCartId(),
                                                    item.getProductId(), item.getItemQty(), item.getPurchaseCost(),
                                                    item.getPurchaseDate()
        );
        newItemEntity = purchasedItemRepository.saveAndFlush(newItemEntity);
        item.setItemId(newItemEntity.getItemId());
        return item;
    }

    @Override
    public PurchasedItemPojo getItem(int itemId) {
        return null;
    }

    @Override
    public boolean addMultipleItems(ArrayList<PurchasedItemPojo> itemList) {
        for (PurchasedItemPojo item : itemList) {
            this.addItem(item);
        }
        return true;
    }

    @Override
    public List<PurchasedItemProduct> getAllPurchasedProductsByTransactionId(int transactionId) {
        List<PurchasedItemEntity> allItems = purchasedItemRepository.findAllByTransactionId(transactionId);
        return getPurchasedItemProducts(allItems);
    }

    @Override
    public List<PurchasedItemProduct> getAllPurchasedProductsByUserId(int userId) {
        List<PurchasedItemEntity> allItems = purchasedItemRepository.findAllByUserId(userId);
        return getPurchasedItemProducts(allItems);
    }


    @NotNull
    private List<PurchasedItemProduct> getPurchasedItemProducts(List<PurchasedItemEntity> allItems) {
        List<PurchasedItemProduct> returningItems = new ArrayList<PurchasedItemProduct>();
        for (PurchasedItemEntity item : allItems) {
            ProductEntity tempProduct = item.getProductEntity();
            ProductPojo productPojo = new  ProductPojo(tempProduct.getProductId(), tempProduct.getProductSku(),
                    tempProduct.getProductName(), tempProduct.getProductCost(),
                    tempProduct.getProductCategory(), tempProduct.getProductDescription(),
                    tempProduct.getProductQty(), tempProduct.getImageUrl(),
                    tempProduct.isProductRemoved());

            PurchasedItemProduct temp = new PurchasedItemProduct(   item.getItemId(), item.getTransactionId(), item.getUserId(),
                                                                    item.getCartId(), item.getProductId(), item.getItemQty(),
                                                                    item.getPurchaseCost(), item.getPurchaseDate(), productPojo
            );
            returningItems.add(temp);
        }
        return returningItems;
    }

}
