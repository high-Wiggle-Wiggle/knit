package com.ggumtle.ggumtle.domain.review;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import com.ggumtle.ggumtle.domain.review.error.PostErrorProperty;
import com.ggumtle.ggumtle.domain.user.User;
import com.ggumtle.ggumtle.shared.entity.BaseTimeEntity;
import com.ggumtle.ggumtle.shared.error.MatzipException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_review")
@Entity
public class Review extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer stars;

    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matzip_id")
    private Matzip matzip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Review(String content, Integer stars, String imageUrl, Matzip matzip, User user) {
        if (!(0 <= stars && stars <= 5)) {
            throw new MatzipException(PostErrorProperty.STARS_NOT_IN_RANGE);
        }

        this.content = content;
        this.stars = stars;
        this.imageUrl = imageUrl;
        this.matzip = matzip;
        this.user = user;
    }
}
