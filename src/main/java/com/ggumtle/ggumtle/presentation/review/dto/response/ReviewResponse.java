package com.ggumtle.ggumtle.presentation.review.dto.response;

import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipDto;
import lombok.Getter;

@Getter
public class ReviewResponse {

    private String content;
    private String userName;
    private MatzipDto matzip;
    private Integer stars;

    public ReviewResponse(Review review) {
        this.content = review.getContent();
        this.userName = review.getUser().getName();
        this.matzip = new MatzipDto(review.getMatzip());
        this.stars = review.getStars();
    }
}
