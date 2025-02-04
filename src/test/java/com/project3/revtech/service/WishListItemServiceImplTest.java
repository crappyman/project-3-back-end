package com.project3.revtech.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.project3.revtech.dao.WishItemRepository;
import com.project3.revtech.entity.DiscountEntity;
import com.project3.revtech.entity.ProductEntity;
import com.project3.revtech.entity.UserEntity;
import com.project3.revtech.entity.WishListEntity;
import com.project3.revtech.entity.WishListItemEntity;
import com.project3.revtech.exception.ApplicationException;
import com.project3.revtech.pojo.WishListItemPojo;

@ContextConfiguration(classes = { WishListItemServiceImpl.class })
@ExtendWith(SpringExtension.class)
public class WishListItemServiceImplTest {

	@MockBean
	private WishItemRepository wishItemRepository;

	@Autowired
	private WishListItemServiceImpl wishListItemServiceImpl;

	@Test
	void testAddItem() throws ApplicationException {
		UserEntity user = new UserEntity();
		user.setAddress("42 Main St");
		user.setContact("Contact");
		user.setEmail("jane.doe@example.org");
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setPassword("iloveyou");
		user.setRoles(new HashSet<>());
		user.setUserId(1);
		user.setUsername("janedoe");

		WishListEntity wishList = new WishListEntity();
		wishList.setWishListId(123);
		wishList.setUserId(1);
		wishList.setWishListTotal(1);
		wishList.setUserEntity(user);
		wishList.setWishListItems(new ArrayList<>());

		DiscountEntity discount = new DiscountEntity();
		discount.setDiscountDescription("3");
		discount.setDiscountId(3);
		discount.setDiscountPercentage(null);
		discount.setProductEntity(new ProductEntity());
		discount.setProductId(123);

		ProductEntity product = new ProductEntity();
		product.setCartItems(new ArrayList<>());
		product.setDiscountEntity(discount);
		product.setImageUrl("https://example.org/example");
		product.setImages(new ArrayList<>());
		product.setProductCategory("Product Category");
		product.setProductCost(BigDecimal.valueOf(42L));
		product.setProductDescription("Product Description");
		product.setProductId(123);
		product.setProductName("Product Name");
		product.setProductQty(1);
		product.setProductRemoved(true);
		product.setProductSku("Product Sku");

		DiscountEntity discount1 = new DiscountEntity();
		discount1.setDiscountDescription("3");
		discount1.setDiscountId(3);
		discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount1.setProductEntity(product);
		discount1.setProductId(123);

		ProductEntity product1 = new ProductEntity();
		product1.setCartItems(new ArrayList<>());
		product1.setDiscountEntity(discount1);
		product1.setImageUrl("https://example.org/example");
		product1.setImages(new ArrayList<>());
		product1.setProductCategory("Product Category");
		product1.setProductCost(BigDecimal.valueOf(42L));
		product1.setProductDescription("Product Description");
		product1.setProductId(123);
		product1.setProductName("Product Name");
		product1.setProductQty(1);
		product1.setProductRemoved(true);
		product1.setProductSku("Product Sku");

		WishListItemEntity wishListItem = new WishListItemEntity();
		wishListItem.setWishListEntity(wishList);
		wishListItem.setWishListId(123);
		wishListItem.setWishItemId(123);
		wishListItem.setProductEntity(product1);
		wishListItem.setProductId(123);
		wishListItem.setWishListQty(1);
		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		when(this.wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt())).thenReturn(true);

		when(this.wishItemRepository.findByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(wishListItem);
		when(this.wishItemRepository.existsByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(true);
		WishListItemPojo wishListItemPojo = new WishListItemPojo(123, 123, 123, 1);

		WishListItemPojo actualAddItemResult = this.wishListItemServiceImpl.addItem(wishListItemPojo);
		assertSame(wishListItemPojo, actualAddItemResult);
		assertEquals(-1 , actualAddItemResult.getWishItemId());
		verify(this.wishItemRepository).deleteById((Integer) any());
		verify(this.wishItemRepository).existsByWishListIdAndProductId(anyInt(), anyInt());
		verify(this.wishItemRepository).existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt());

		verify(this.wishItemRepository, atLeast(1)).findByWishListIdAndProductId(anyInt(), anyInt());

	}

	@Test
	void testAddItem2() throws ApplicationException {
		UserEntity user = new UserEntity();
		user.setAddress("42 Main St");
		user.setContact("Contact");
		user.setEmail("jane.doe@example.org");
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setPassword("iloveyou");
		user.setRoles(new HashSet<>());
		user.setUserId(1);
		user.setUsername("janedoe");

		WishListEntity wishList = new WishListEntity();
		wishList.setWishListId(123);
		wishList.setUserId(1);
		wishList.setWishListTotal(1);
		wishList.setUserEntity(user);
		wishList.setWishListItems(new ArrayList<>());

		DiscountEntity discount = new DiscountEntity();
		discount.setDiscountDescription("3");
		discount.setDiscountId(3);
		discount.setDiscountPercentage(null);
		discount.setProductEntity(new ProductEntity());
		discount.setProductId(1);

		ProductEntity product = new ProductEntity();
		product.setCartItems(new ArrayList<>());
		product.setDiscountEntity(discount);
		product.setImageUrl("https://example.org/example");
		product.setImages(new ArrayList<>());
		product.setProductCategory("Product Category");
		product.setProductCost(BigDecimal.valueOf(42L));
		product.setProductDescription("Product Description");
		product.setProductId(123);
		product.setProductName("Product Name");
		product.setProductQty(1);
		product.setProductRemoved(true);
		product.setProductSku("Product Sku");

		DiscountEntity discount1 = new DiscountEntity();
		discount1.setDiscountDescription("3");
		discount1.setDiscountId(3);
		discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount1.setProductEntity(product);
		discount1.setProductId(123);

		ProductEntity product1 = new ProductEntity();
		product1.setCartItems(new ArrayList<>());
		product1.setDiscountEntity(discount1);
		product1.setImageUrl("https://example.org/example");
		product1.setImages(new ArrayList<>());
		product1.setProductCategory("Product Category");
		product1.setProductCost(BigDecimal.valueOf(42L));
		product1.setProductDescription("Product Description");
		product1.setProductId(123);
		product1.setProductName("Product Name");
		product1.setProductQty(1);
		product1.setProductRemoved(true);
		product1.setProductSku("Product Sku");

		WishListItemEntity wishListItem = new WishListItemEntity();
		wishListItem.setWishListEntity(wishList);
		wishListItem.setProductId(123);
		wishListItem.setWishItemId(123);
		wishListItem.setProductEntity(product1);
		wishListItem.setWishListQty(1);

		UserEntity user1 = new UserEntity();
		user1.setAddress("42 Main St");
		user1.setContact("Contact");
		user1.setEmail("jane.doe@example.org");
		user1.setFirstName("Jane");
		user1.setLastName("Doe");
		user1.setPassword("iloveyou");
		user1.setRoles(new HashSet<>());
		user1.setUserId(1);
		user1.setUsername("janedoe");

		WishListEntity wishList1 = new WishListEntity();
		wishList1.setWishListId(123);
		wishList1.setUserId(123);
		wishList1.setWishListTotal(1);
		wishList1.setUserEntity(user1);
		wishList1.setWishListItems(new ArrayList<>());

		DiscountEntity discount2 = new DiscountEntity();
		discount2.setDiscountDescription("3");
		discount2.setDiscountId(3);
		discount2.setDiscountPercentage(null);
		discount2.setProductEntity(new ProductEntity());
		discount2.setProductId(123);

		ProductEntity product2 = new ProductEntity();
		product2.setCartItems(new ArrayList<>());
		product2.setDiscountEntity(discount2);
		product2.setImageUrl("https://example.org/example");
		product2.setImages(new ArrayList<>());
		product2.setProductCategory("Product Category");
		product2.setProductCost(BigDecimal.valueOf(42L));
		product2.setProductDescription("Product Description");
		product2.setProductId(123);
		product2.setProductName("Product Name");
		product2.setProductQty(1);
		product2.setProductRemoved(true);
		product2.setProductSku("Product Sku");

		DiscountEntity discount3 = new DiscountEntity();
		discount3.setDiscountDescription("3");
		discount3.setDiscountId(3);
		discount3.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount3.setProductEntity(product2);
		discount3.setProductId(123);

		ProductEntity product3 = new ProductEntity();
		product3.setCartItems(new ArrayList<>());
		product3.setDiscountEntity(discount3);
		product3.setImageUrl("https://example.org/example");
		product3.setImages(new ArrayList<>());
		product3.setProductCategory("Product Category");
		product3.setProductCost(BigDecimal.valueOf(42L));
		product3.setProductDescription("Product Description");
		product3.setProductId(123);
		product3.setProductName("Product Name");
		product3.setProductQty(1);
		product3.setProductRemoved(true);
		product3.setProductSku("Product Sku");

		WishListItemEntity WishItem1 = new WishListItemEntity();
		WishItem1.setWishListEntity(wishList1);
		WishItem1.setWishListId(123);
		WishItem1.setWishItemId(123);
		WishItem1.setProductEntity(product3);
		WishItem1.setProductId(123);
		wishListItem.setWishListQty(1);
		when(this.wishItemRepository.save((WishListItemEntity) any())).thenReturn(WishItem1);
		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		when(this.wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt())).thenReturn(false);

		when(this.wishItemRepository.findByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(wishListItem);
		when(this.wishItemRepository.existsByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(true);
		WishListItemPojo wishItemPojo = new WishListItemPojo(123, 123, 123, 1);

		WishListItemPojo actualAddItemResult = this.wishListItemServiceImpl.addItem(wishItemPojo);
		assertSame(wishItemPojo, actualAddItemResult);
		assertEquals(123, actualAddItemResult.getWishItemId());
		verify(this.wishItemRepository).existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt());

		verify(this.wishItemRepository).existsByWishListIdAndProductId(anyInt(), anyInt());
		verify(this.wishItemRepository, atLeast(1)).findByWishListIdAndProductId(anyInt(), anyInt());
		verify(this.wishItemRepository).save((WishListItemEntity) any());
	}

	@Test
	void testUpdateItem() throws ApplicationException {

		UserEntity user = new UserEntity();
		user.setAddress("42 Main St");
		user.setContact("Contact");
		user.setEmail("jane.doe@example.org");
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setPassword("iloveyou");
		user.setRoles(new HashSet<>());
		user.setUserId(1);
		user.setUsername("janedoe");

		WishListEntity wishList1 = new WishListEntity();
		wishList1.setWishListId(123);
		wishList1.setUserId(123);
		wishList1.setWishListTotal(5);
		wishList1.setUserEntity(user);
		wishList1.setWishListItems(new ArrayList<>());

		DiscountEntity discount = new DiscountEntity();
		discount.setDiscountDescription("3");
		discount.setDiscountId(3);
		discount.setDiscountPercentage(null);
		discount.setProductEntity(new ProductEntity());
		discount.setProductId(123);

		ProductEntity product = new ProductEntity();
		product.setCartItems(new ArrayList<>());
		product.setDiscountEntity(discount);
		product.setImageUrl("https://example.org/example");
		product.setImages(new ArrayList<>());
		product.setProductCategory("Product Category");
		product.setProductCost(BigDecimal.valueOf(42L));
		product.setProductDescription("Product Description");
		product.setProductId(123);
		product.setProductName("Product Name");
		product.setProductQty(1);
		product.setProductRemoved(true);
		product.setProductSku("Product Sku");

		DiscountEntity discount1 = new DiscountEntity();
		discount1.setDiscountDescription("3");
		discount1.setDiscountId(3);
		discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount1.setProductEntity(product);
		discount1.setProductId(123);

		ProductEntity product1 = new ProductEntity();
		product1.setCartItems(new ArrayList<>());
		product1.setDiscountEntity(discount1);
		product1.setImageUrl("https://example.org/example");
		product1.setImages(new ArrayList<>());
		product1.setProductCategory("Product Category");
		product1.setProductCost(BigDecimal.valueOf(42L));
		product1.setProductDescription("Product Description");
		product1.setProductId(123);
		product1.setProductName("Product Name");
		product1.setProductQty(1);
		product1.setProductRemoved(true);
		product1.setProductSku("Product Sku");

		WishListItemEntity wishListItem = new WishListItemEntity();
		wishListItem.setWishListEntity(wishList1);
		wishListItem.setWishListId(123);
		wishListItem.setWishItemId(123);
		wishListItem.setProductEntity(product1);
		wishListItem.setProductId(123);
		wishListItem.setWishListQty(10);
		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		when(this.wishItemRepository.findByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(wishListItem);
		WishListItemPojo wishListItemPojo = new WishListItemPojo(123, 123, 123, 0);

		WishListItemPojo actualUpdateItemResult = this.wishListItemServiceImpl.updateItem(wishListItemPojo);
		assertSame(wishListItemPojo, actualUpdateItemResult);
		assertEquals(-1, actualUpdateItemResult.getWishItemId());
		verify(this.wishItemRepository).deleteById((Integer) any());
		verify(this.wishItemRepository).findByWishListIdAndProductId(anyInt(), anyInt());
	}

	@Test
	void testUpdateItem2() throws ApplicationException {

		UserEntity user = new UserEntity();
		user.setAddress("42 Main St");
		user.setContact("Contact");
		user.setEmail("jane.doe@example.org");
		user.setFirstName("Jane");
		user.setLastName("Doe");
		user.setPassword("iloveyou");
		user.setRoles(new HashSet<>());
		user.setUserId(1);
		user.setUsername("janedoe");

		WishListEntity wishList1 = new WishListEntity();
		wishList1.setWishListId(123);
		wishList1.setUserId(123);
		wishList1.setWishListTotal(1);
		wishList1.setUserEntity(user);
		wishList1.setWishListItems(new ArrayList<>());

		DiscountEntity discount = new DiscountEntity();
		discount.setDiscountDescription("3");
		discount.setDiscountId(3);
		discount.setDiscountPercentage(null);
		discount.setProductEntity(new ProductEntity());
		discount.setProductId(123);

		ProductEntity product = new ProductEntity();
		product.setCartItems(new ArrayList<>());
		product.setDiscountEntity(discount);
		product.setImageUrl("https://example.org/example");
		product.setImages(new ArrayList<>());
		product.setProductCategory("Product Category");
		product.setProductCost(BigDecimal.valueOf(42L));
		product.setProductDescription("Product Description");
		product.setProductId(123);
		product.setProductName("Product Name");
		product.setProductQty(1);
		product.setProductRemoved(true);
		product.setProductSku("Product Sku");

		DiscountEntity discount1 = new DiscountEntity();
		discount1.setDiscountDescription("3");
		discount1.setDiscountId(3);
		discount1.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount1.setProductEntity(product);
		discount1.setProductId(123);

		ProductEntity product1 = new ProductEntity();
		product1.setCartItems(new ArrayList<>());
		product1.setDiscountEntity(discount1);
		product1.setImageUrl("https://example.org/example");
		product1.setImages(new ArrayList<>());
		product1.setProductCategory("Product Category");
		product1.setProductCost(BigDecimal.valueOf(42L));
		product1.setProductDescription("Product Description");
		product1.setProductId(123);
		product1.setProductName("Product Name");
		product1.setProductQty(1);
		product1.setProductRemoved(true);
		product1.setProductSku("Product Sku");

		WishListItemEntity wishListItem = new WishListItemEntity();
		wishListItem.setWishListEntity(wishList1);
		wishListItem.setWishListId(123);
		wishListItem.setWishItemId(123);
		wishListItem.setProductEntity(product1);
		wishListItem.setProductId(123);
		wishListItem.setWishListQty(1);
		
		UserEntity user1 = new UserEntity();
		user1.setAddress("42 Main St");
		user1.setContact("Contact");
		user1.setEmail("jane.doe@example.org");
		user1.setFirstName("Jane");
		user1.setLastName("Doe");
		user1.setPassword("iloveyou");
		user1.setRoles(new HashSet<>());
		user1.setUserId(1);
		user1.setUsername("janedoe");

		WishListEntity wishList2 = new WishListEntity();
		wishList2.setWishListId(123);
		wishList2.setUserId(1);
		wishList2.setWishListTotal(1);
		wishList2.setUserEntity(user1);
		wishList2.setWishListItems(new ArrayList<>());

		DiscountEntity discount2 = new DiscountEntity();
		discount2.setDiscountDescription("3");
		discount2.setDiscountId(3);
		discount2.setDiscountPercentage(null);
		discount2.setProductEntity(new ProductEntity());
		discount2.setProductId(123);

		ProductEntity product2 = new ProductEntity();
		product2.setCartItems(new ArrayList<>());
		product2.setDiscountEntity(discount2);
		product2.setImageUrl("https://example.org/example");
		product2.setImages(new ArrayList<>());
		product2.setProductCategory("Product Category");
		product2.setProductCost(BigDecimal.valueOf(42L));
		product2.setProductDescription("Product Description");
		product2.setProductId(123);
		product2.setProductName("Product Name");
		product2.setProductQty(1);
		product2.setProductRemoved(true);
		product2.setProductSku("Product Sku");

		DiscountEntity discount3 = new DiscountEntity();
		discount3.setDiscountDescription("3");
		discount3.setDiscountId(3);
		discount3.setDiscountPercentage(BigDecimal.valueOf(42L));
		discount3.setProductEntity(product2);
		discount3.setProductId(123);

		ProductEntity product3 = new ProductEntity();
		product3.setCartItems(new ArrayList<>());
		product3.setDiscountEntity(discount3);
		product3.setImageUrl("https://example.org/example");
		product3.setImages(new ArrayList<>());
		product3.setProductCategory("Product Category");
		product3.setProductCost(BigDecimal.valueOf(42L));
		product3.setProductDescription("Product Description");
		product3.setProductId(123);
		product3.setProductName("Product Name");
		product3.setProductQty(1);
		product3.setProductRemoved(true);
		product3.setProductSku("Product Sku");

		WishListItemEntity wishListItem1 = new WishListItemEntity();
		wishListItem1.setWishListEntity(wishList2);
		wishListItem1.setWishListId(123);
		wishListItem1.setWishItemId(123);
		wishListItem1.setProductEntity(product3);
		wishListItem1.setProductId(123);
		wishListItem1.setWishListQty(1);

		when(this.wishItemRepository.save((WishListItemEntity) any())).thenReturn(wishListItem1);

		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		when(this.wishItemRepository.existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt())).thenReturn(false);

		when(this.wishItemRepository.findByWishListIdAndProductId(anyInt(), anyInt())).thenReturn(wishListItem);
		WishListItemPojo wishListItemPojo = new WishListItemPojo(123, 123, 123, 1);
		WishListItemPojo actualUpdateItemResult = this.wishListItemServiceImpl.updateItem(wishListItemPojo);
		assertSame(wishListItemPojo, actualUpdateItemResult);
		assertEquals(123, actualUpdateItemResult.getWishItemId());
		verify(this.wishItemRepository).existsByWishListQtyIsLessThanAndWishListIdAndProductId(anyInt(), anyInt(),
				anyInt());

		verify(this.wishItemRepository).findByWishListIdAndProductId(anyInt(), anyInt());
		verify(this.wishItemRepository).save((WishListItemEntity) any());

	}

	@Test
	void testGetWishListItem() throws ApplicationException {
		assertNull(this.wishListItemServiceImpl.getWishListItem(42));
	}

	@Test
	void testRemoveItem() throws ApplicationException {
		doNothing().when(this.wishItemRepository).deleteById((Integer) any());
		assertTrue(this.wishListItemServiceImpl.removeItem(123));
		verify(this.wishItemRepository).deleteById((Integer) any());
	}

}
