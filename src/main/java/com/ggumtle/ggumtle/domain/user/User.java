package com.ggumtle.ggumtle.domain.user;

import com.ggumtle.ggumtle.domain.follow.Follow;
import com.ggumtle.ggumtle.domain.review.Review;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    // 팔로우 하고 있는 사람
    @OneToMany(mappedBy = "follower")
    private List<Follow> followings;

    // 팔로우 당한 사람
    @OneToMany(mappedBy = "followee")
    private List<Follow> followers;
}
