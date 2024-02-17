package com.ggumtle.ggumtle.presentation.matzip.dto.response;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import lombok.Getter;

@Getter
public class MatzipResponse {

    private Long id;
    private String name;
    private String imageUrl;

    public MatzipResponse(Matzip matzip) {
        this.id = matzip.getId();
        this.name = matzip.getName();
        this.imageUrl = matzip.getImageUrl();
    }
}
