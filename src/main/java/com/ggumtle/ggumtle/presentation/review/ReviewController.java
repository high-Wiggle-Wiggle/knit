package com.ggumtle.ggumtle.presentation.review;

import com.ggumtle.ggumtle.application.review.ReviewService;
import com.ggumtle.ggumtle.domain.user.constants.UserConstants;
import com.ggumtle.ggumtle.presentation.review.dto.request.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/reviews")
@RestController
public class ReviewController {

    private final ReviewService reviewService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createReview(
            @RequestHeader(UserConstants.LOGIN_USER_HEADER) Long userId,
            @RequestBody ReviewRequest request
    ) {
        reviewService.createReview(userId, request);
    }

}
