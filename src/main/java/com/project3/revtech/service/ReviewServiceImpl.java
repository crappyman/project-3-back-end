package com.project3.revtech.service;

import com.project3.revtech.dao.ReviewRepository;
import com.project3.revtech.entity.ReviewEntity;
import com.project3.revtech.joinedpojo.UserReviewPojo;
import com.project3.revtech.pojo.ReviewPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public ReviewPojo addReview(ReviewPojo review) {
        ReviewEntity newReview = new ReviewEntity(review.getUserId(), review.getProductId(), review.getTitle(), review.getRating(), review.getReview());
        newReview =  reviewRepository.saveAndFlush(newReview);
        review.setReviewId(newReview.getReviewId());
        return review;
    }

    @Override
    public ReviewPojo updateReview(ReviewPojo review) {
        return null;
    }

    @Override
    public List<UserReviewPojo> getReviewsOfProduct(int productId) {
        List<ReviewEntity> allReviews = reviewRepository.findAllByProductIdEquals(productId);
        List<UserReviewPojo> returningReviews = new ArrayList<UserReviewPojo>();
        for (ReviewEntity review : allReviews) {
            UserReviewPojo temp = new UserReviewPojo(   review.getReviewId(), review.getUserId(), review.getUserEntity().getFirstName(),
                                                        review.getUserEntity().getLastName(), review.getProductId(), review.getDate(),
                                                        review.getTitle(), review.getRating(), review.getReview()
            );
            returningReviews.add(temp);
        }
        return returningReviews;
    }
}
