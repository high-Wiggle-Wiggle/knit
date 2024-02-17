package com.ggumtle.ggumtle.presentation.review.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequest {

    private String content;
    private Integer stars;
    private Long matzipId;
}
