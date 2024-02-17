package com.ggumtle.ggumtle.infrastructure.persistence.user;

import com.ggumtle.ggumtle.domain.user.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
