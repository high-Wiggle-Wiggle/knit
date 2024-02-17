package com.ggumtle.ggumtle.presentation.matzip.dto.response;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import com.ggumtle.ggumtle.presentation.review.dto.response.ReviewResponse;
import lombok.Getter;

import java.util.List;

@Getter
public class MatzipDetailResponse {

    private String name;
    private String address;
    private String phoneNumber;
    private String type;
    private Double latitude;
    private Double longitude;
    private String imageUrl;

    private Double averageStar;
    private Integer reviewCounts;

    private List<ReviewResponse> reviews;

    public MatzipDetailResponse(Matzip matzip) {
        this.name = matzip.getName();
        this.address = matzip.getAddress();
        this.phoneNumber = matzip.getPhoneNumber();
        this.type = matzip.getType();
        this.latitude = matzip.getLatitude();
        this.longitude = matzip.getLongitude();
        this.imageUrl = matzip.getImageUrl();
        this.averageStar = matzip.getAverageStar();
        this.reviewCounts = matzip.getReviewCounts();
        this.reviews = matzip.getReviews().stream()
                .map(ReviewResponse::new)
                .toList();
    }
}
