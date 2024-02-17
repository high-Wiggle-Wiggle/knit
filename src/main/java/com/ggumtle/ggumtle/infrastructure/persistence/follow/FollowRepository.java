package com.ggumtle.ggumtle.infrastructure.persistence.follow;

import com.ggumtle.ggumtle.domain.follow.Follow;
import com.ggumtle.ggumtle.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Long>, FollowRepositoryCustom {

    void deleteByFollowerAndFollowee(User follower, User followee);
}
