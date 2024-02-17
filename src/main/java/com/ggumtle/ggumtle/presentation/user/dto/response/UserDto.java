package com.ggumtle.ggumtle.presentation.user.dto.response;

import com.ggumtle.ggumtle.domain.user.User;
import lombok.Getter;

@Getter
public class UserDto {

    private Long id;
    private String name;
    private String imageUrl;

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.imageUrl = user.getImageUrl();
    }
}
