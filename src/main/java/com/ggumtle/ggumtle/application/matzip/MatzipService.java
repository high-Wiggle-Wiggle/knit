package com.ggumtle.ggumtle.application.matzip;

import com.ggumtle.ggumtle.infrastructure.persistence.matzip.MatzipRepository;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MatzipService {

    private final MatzipRepository matzipRepository;

    @Transactional(readOnly = true)
    public MatzipResponse getMatzip(Long id) {
        return null;
    }
}
