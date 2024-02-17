package com.ggumtle.ggumtle.domain.user.service;

import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.domain.user.error.UserErrorProperty;
import com.ggumtle.ggumtle.infrastructure.persistence.user.UserRepository;
import com.ggumtle.ggumtle.shared.error.MatzipException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new MatzipException(UserErrorProperty.USER_NOT_FOUND));
    }
}
