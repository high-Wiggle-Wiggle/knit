package com.ggumtle.ggumtle.application.user;

import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.domain.user.service.UserFacade;
import com.ggumtle.ggumtle.infrastructure.persistence.user.UserRepository;
import com.ggumtle.ggumtle.presentation.user.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public UserResponse getProfile(Long id) {
        User user = userFacade.getUser(id);

        return new UserResponse(user);
    }
}
