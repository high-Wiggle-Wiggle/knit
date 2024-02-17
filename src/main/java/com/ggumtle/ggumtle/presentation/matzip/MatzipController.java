package com.ggumtle.ggumtle.presentation.matzip;

import com.ggumtle.ggumtle.application.matzip.MatzipService;
import com.ggumtle.ggumtle.presentation.matzip.dto.response.MatzipResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "맛집")
@RequiredArgsConstructor
@RequestMapping("/matzips")
@RestController
public class MatzipController {

    private final MatzipService matzipService;

    @GetMapping("/{id}")
    public MatzipResponse getMatzip(
        @PathVariable("id") Long id
    ) {
        return matzipService.getMatzip(id);
    }
}
