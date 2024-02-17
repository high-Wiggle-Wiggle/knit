package com.ggumtle.ggumtle.presentation.review.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SearchReviewResponse {

    private List<ReviewResponse> reviews;
}
