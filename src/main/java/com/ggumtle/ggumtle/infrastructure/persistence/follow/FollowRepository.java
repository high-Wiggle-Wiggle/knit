package com.ggumtle.ggumtle.infrastructure.persistence.follow;

import com.ggumtle.ggumtle.domain.follow.Follow;
import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Long> {
}
