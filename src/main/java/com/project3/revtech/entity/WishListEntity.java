package com.project3.revtech.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "wish_list_details")
public class WishListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_list_id")
	private int wishListId;
	
	@NotNull
	@Column(name = "user_id")
	private int userId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity userEntity; 
    
	@OneToMany(mappedBy = "wishListEntity")
    private List<WishListItemEntity> wishListItems;
	
	@Column(name = "wishList_total")
	private int wishListTotal;

	

	public WishListEntity(@NotNull int userId, int wishListTotal) {
		super();
		this.userId = userId;
		this.wishListTotal = wishListTotal;
	}



	public WishListEntity(int wishListId, @NotNull int userId, int wishListTotal) {
		super();
		this.wishListId = wishListId;
		this.userId = userId;
		this.wishListTotal = wishListTotal;
	}
	
	
}
