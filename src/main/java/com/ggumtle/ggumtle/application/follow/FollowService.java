package com.ggumtle.ggumtle.application.follow;

import com.ggumtle.ggumtle.domain.follow.Follow;
import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.domain.user.service.UserFacade;
import com.ggumtle.ggumtle.infrastructure.persistence.follow.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowService {

    private final FollowRepository followRepository;
    private final UserFacade userFacade;

    @Transactional
    public void follow(Long userId, Long followeeId) {
        User currentUser = userFacade.getUser(userId);
        User followee = userFacade.getUser(followeeId);

        followRepository.save(new Follow(followee, currentUser));
    }

    @Transactional
    public void unfollow(Long userId, Long followeeId) {
        User currentUser = userFacade.getUser(userId);
        User followee = userFacade.getUser(followeeId);

        followRepository.deleteByFollowerAndFollowee(currentUser, followee);
    }
}
