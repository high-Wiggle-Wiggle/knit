package com.ggumtle.ggumtle.infrastructure.persistence.follow;

import com.ggumtle.ggumtle.domain.follow.Follow;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import static com.ggumtle.ggumtle.domain.follow.QFollow.follow;

public class FollowRepositoryCustomImpl extends QuerydslRepositorySupport implements FollowRepositoryCustom {

    public FollowRepositoryCustomImpl() {
        super(Follow.class);
    }

    @Override
    public boolean isFollowing(Long userId, Long followeeId) {
        return from(follow)
                .where(follow.follower.id.eq(userId)
                        .and(follow.followee.id.eq(followeeId)))
                .fetchOne() != null;
    }
}
