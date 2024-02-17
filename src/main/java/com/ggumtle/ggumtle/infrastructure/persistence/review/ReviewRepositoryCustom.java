package com.ggumtle.ggumtle.infrastructure.persistence.review;

import com.ggumtle.ggumtle.domain.review.Review;

import java.util.List;

public interface ReviewRepositoryCustom {

    List<Review> searchReview(String q);

    List<Review> getFeed(Long userId);
}
