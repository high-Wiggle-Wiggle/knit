package com.ggumtle.ggumtle.domain.review.error;

import com.ggumtle.ggumtle.shared.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostErrorProperty implements ErrorProperty {

    STARS_NOT_IN_RANGE(HttpStatus.BAD_REQUEST, "별점은 1점부터 5점까지만 가능합니다.");

    private final HttpStatus status;
    private final String message;
}
