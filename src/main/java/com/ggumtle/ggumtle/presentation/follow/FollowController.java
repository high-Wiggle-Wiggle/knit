package com.ggumtle.ggumtle.presentation.follow;

import com.ggumtle.ggumtle.application.follow.FollowService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static com.ggumtle.ggumtle.domain.user.constants.UserConstants.LOGIN_USER_HEADER;

@Tag(name = "팔로우")
@RequiredArgsConstructor
@RequestMapping("/follows")
@RestController
public class FollowController {

    private final FollowService followService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void follow(
            @RequestHeader(LOGIN_USER_HEADER) Long userId,
            @RequestParam("followee-id") Long followeeId
    ) {
        followService.follow(userId, followeeId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void unfollow(
            @RequestHeader(LOGIN_USER_HEADER) Long userId,
            @RequestParam("followee-id") Long followeeId
    ) {
        followService.unfollow(userId, followeeId);
    }

    @GetMapping
    public boolean isFollowing(
            @RequestHeader(LOGIN_USER_HEADER) Long userId,
            @RequestParam("followee-id") Long followeeId
    ) {
        return followService.isFollowing(userId, followeeId);
    }
}
