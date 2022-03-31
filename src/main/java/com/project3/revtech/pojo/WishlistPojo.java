package com.project3.revtech.pojo;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WishlistPojo {
	
	private int  wishlistId;
	private int  userId;
	private Date createdDate;
	private int  productId;

}
