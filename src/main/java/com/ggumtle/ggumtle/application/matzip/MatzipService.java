package com.ggumtle.ggumtle.application.matzip;

import com.ggumtle.ggumtle.infrastructure.persistence.matzip.MatzipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MatzipService {

    private final MatzipRepository matzipRepository;
}
