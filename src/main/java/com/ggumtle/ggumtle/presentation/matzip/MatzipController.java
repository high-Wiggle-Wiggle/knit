package com.ggumtle.ggumtle.presentation.matzip;

import com.ggumtle.ggumtle.application.matzip.MatzipService;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipDetailResponse;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.SearchMatzipListResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "맛집")
@RequiredArgsConstructor
@RequestMapping("/matzips")
@RestController
public class MatzipController {

    private final MatzipService matzipService;

    @GetMapping
    public SearchMatzipListResponse searchMatzip(
            @RequestParam(required = false) String q
    ) {
        return matzipService.searchMatzip(q);
    }

    @GetMapping("/{id}")
    public MatzipDetailResponse getMatzip(
            @PathVariable("id") Long id
    ) {
        return matzipService.getMatzip(id);
    }
}
