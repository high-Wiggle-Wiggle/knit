package com.ggumtle.ggumtle.presentation.user.dto.response;

import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.presentation.review.dto.response.ReviewResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class UserResponse {

    private String name;

    private Integer review;
    private Integer follower;
    private Integer following;

    private List<ReviewResponse> reviews;

    public UserResponse(User user) {
        this.name = user.getName();
        this.review = user.getReviews().size();
        this.follower = user.getFollowers().size();
        this.following = user.getFollowings().size();
        this.reviews = user.getReviews().stream()
                .map(ReviewResponse::new)
                .toList();
    }
}
