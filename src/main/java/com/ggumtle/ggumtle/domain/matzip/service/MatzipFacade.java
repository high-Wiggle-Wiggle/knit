package com.ggumtle.ggumtle.domain.matzip.service;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import com.ggumtle.ggumtle.infrastructure.persistence.matzip.MatzipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MatzipFacade {

    private final MatzipRepository matzipRepository;

    public Matzip getMatzip(Long id) {
        return matzipRepository.findById(id)
                .orElseThrow();
    }
}
