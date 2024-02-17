package com.ggumtle.ggumtle.application.review;

import com.ggumtle.ggumtle.infrastructure.persistence.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
}
