package com.ggumtle.ggumtle.presentation.matzip.dto.response;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import lombok.Getter;

@Getter
public class MatzipResponse {

    private Long id;
    private String name;
    private String address;
    private Double averageStar;
    private Integer reviewCounts;

    public MatzipResponse(Matzip matzip) {
        this.id = matzip.getId();
        this.name = matzip.getName();
        this.address = matzip.getAddress();
        this.averageStar = matzip.getAverageStar();
        this.reviewCounts = matzip.getReviewCounts();
    }
}
