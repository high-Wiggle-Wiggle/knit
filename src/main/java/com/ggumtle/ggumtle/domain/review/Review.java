package com.ggumtle.ggumtle.domain.review;

import com.ggumtle.ggumtle.domain.review.error.PostErrorProperty;
import com.ggumtle.ggumtle.shared.entity.BaseTimeEntity;
import com.ggumtle.ggumtle.shared.error.MatzipException;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Integer stars;

    public Review(String title, String content, Integer stars) {
        if (!(0 <= stars && stars <= 5)) {
            throw new MatzipException(PostErrorProperty.STARS_NOT_IN_RANGE);
        }

        this.title = title;
        this.content = content;
        this.stars = stars;
    }
}
