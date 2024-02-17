package com.ggumtle.ggumtle.presentation.user;

import com.ggumtle.ggumtle.application.user.UserService;
import com.ggumtle.ggumtle.presentation.user.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저")
@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public UserResponse getProfile(
            @PathVariable("id") Long id
    ) {
        return userService.getProfile(id);
    }
}
