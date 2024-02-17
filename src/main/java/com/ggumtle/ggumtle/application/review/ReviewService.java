package com.ggumtle.ggumtle.application.review;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import com.ggumtle.ggumtle.domain.matzip.service.MatzipFacade;
import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.domain.user.service.UserFacade;
import com.ggumtle.ggumtle.infrastructure.persistence.review.ReviewRepository;
import com.ggumtle.ggumtle.presentation.review.dto.request.ReviewRequest;
import com.ggumtle.ggumtle.presentation.review.dto.response.ReviewListResponse;
import com.ggumtle.ggumtle.presentation.review.dto.response.ReviewResponse;
import com.ggumtle.ggumtle.presentation.review.dto.response.SearchReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserFacade userFacade;
    private final MatzipFacade matzipFacade;

    @Transactional
    public void createReview(Long userId, ReviewRequest request) {
        User user = userFacade.getUser(userId);
        Matzip matzip = matzipFacade.getMatzip(request.getMatzipId());

        reviewRepository.save(
                new Review(
                        request.getContent(),
                        request.getStars(),
                        matzip,
                        user
                )
        );
    }

    @Transactional(readOnly = true)
    public SearchReviewResponse searchReview(String q) {
        return new SearchReviewResponse(
                reviewRepository.searchReview(q) .stream()
                        .map(ReviewResponse::new)
                        .toList()
        );
    }

    @Transactional(readOnly = true)
    public ReviewListResponse getReviewList(Long userId) {
        return new ReviewListResponse(
                reviewRepository.getFeed(userId).stream()
                        .map(ReviewResponse::new)
                        .toList()
        );
    }
}
