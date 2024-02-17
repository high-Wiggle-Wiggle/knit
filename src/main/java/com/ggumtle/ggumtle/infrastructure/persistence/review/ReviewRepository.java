package com.ggumtle.ggumtle.infrastructure.persistence.review;

import com.ggumtle.ggumtle.domain.review.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepository extends CrudRepository<Review, Long>, ReviewRepositoryCustom {
}
