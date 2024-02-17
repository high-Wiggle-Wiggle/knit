package com.ggumtle.ggumtle.application.matzip;

import com.ggumtle.ggumtle.infrastructure.persistence.matzip.MatzipRepository;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipDetailResponse;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipDto;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipResponse;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.SearchMatzipListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MatzipService {

    private final MatzipRepository matzipRepository;

    @Transactional(readOnly = true)
    public SearchMatzipListResponse searchMatzip(String q) {
        return new SearchMatzipListResponse(
                matzipRepository.searchMatzip(q).stream()
                .map(MatzipResponse::new)
                .toList()
        );
    }

    @Transactional(readOnly = true)
    public MatzipDetailResponse getMatzip(Long id) {
        return null;
    }
}
