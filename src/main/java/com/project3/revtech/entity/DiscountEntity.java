package com.project3.revtech.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "discount_details")
public class DiscountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discount_id")
	private int discountId;

	@Column(name = "product_id")
	private int productId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
	private ProductEntity productEntity;

	@Column(name = "discount_description")
	private String discountDescription;

	@Column(name = "discount_percentage")
	private BigDecimal discountPercentage;

	public DiscountEntity(int discountId, int productId, String discountDescription, BigDecimal discountPercentage) {
		this.discountId = discountId;
		this.productId = productId;
		this.discountDescription = discountDescription;
		this.discountPercentage = discountPercentage;
	}

	public DiscountEntity(boolean isNull) {
		if(isNull) {
			this.discountId = -1;
			this.productId = -1;
			this.discountDescription = "N/A";
			this.discountPercentage = new BigDecimal("0.0");
		}
	}
}
