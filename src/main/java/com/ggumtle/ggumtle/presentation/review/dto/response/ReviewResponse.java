package com.ggumtle.ggumtle.presentation.review.dto.response;

import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipDto;
import com.ggumtle.ggumtle.presentation.user.dto.response.UserDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewResponse {

    private UserDto user;
    private String content;
    private MatzipDto matzip;
    private Integer stars;
    private LocalDateTime createdAt;

    public ReviewResponse(Review review) {
        this.user = new UserDto(review.getUser());
        this.content = review.getContent();
        this.matzip = new MatzipDto(review.getMatzip());
        this.stars = review.getStars();
        this.createdAt = review.getCreatedAt();
    }
}
