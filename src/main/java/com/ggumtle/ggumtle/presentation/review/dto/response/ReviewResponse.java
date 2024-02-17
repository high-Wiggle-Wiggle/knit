package com.ggumtle.ggumtle.presentation.review.dto.response;

import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipResponse;
import lombok.Getter;

@Getter
public class ReviewResponse {

    private String content;
    private String userName;
    private MatzipResponse matzip;
    private Integer stars;

    public ReviewResponse(Review review) {
        this.content = review.getContent();
        this.userName = review.getUser().getName();
        this.matzip = new MatzipResponse(review.getMatzip());
        this.stars = review.getStars();
    }
}
