package com.ggumtle.ggumtle.presentation.matzip.dto.response;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import lombok.Getter;

@Getter
public class MatzipDto {

    private Long id;
    private String name;

    public MatzipDto(Matzip matzip) {
        this.id = matzip.getId();
        this.name = matzip.getName();
    }
}
