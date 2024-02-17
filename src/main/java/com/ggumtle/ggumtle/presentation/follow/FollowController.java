package com.ggumtle.ggumtle.presentation.follow;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "팔로우")
@RequiredArgsConstructor
@RequestMapping("/follows")
@RestController
public class FollowController {
}
