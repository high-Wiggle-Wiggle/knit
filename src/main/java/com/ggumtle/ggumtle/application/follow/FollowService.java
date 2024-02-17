package com.ggumtle.ggumtle.application.follow;

import com.ggumtle.ggumtle.infrastructure.persistence.follow.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowRepository followRepository;
}
