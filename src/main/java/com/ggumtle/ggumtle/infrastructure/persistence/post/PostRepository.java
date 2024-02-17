package com.ggumtle.ggumtle.infrastructure.persistence.post;

import com.ggumtle.ggumtle.domain.post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
