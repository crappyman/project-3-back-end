package com.project3.revtech.joinedpojo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReviewPojo {

    private int reviewId;
    private int userId;
    private String firstName;
    private String lastName;
    private int productId;
    private Date date;
    private String title;
    private int rating;
    private String review;

}
