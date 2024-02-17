package com.ggumtle.ggumtle.presentation.matzip;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "맛집")
@RequiredArgsConstructor
@RequestMapping("/matzips")
@RestController
public class MatzipController {
}
