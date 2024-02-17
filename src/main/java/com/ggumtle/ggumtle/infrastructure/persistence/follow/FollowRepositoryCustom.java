package com.ggumtle.ggumtle.infrastructure.persistence.follow;

public interface FollowRepositoryCustom {

    boolean isFollowing(Long userId, Long followeeId);
}
