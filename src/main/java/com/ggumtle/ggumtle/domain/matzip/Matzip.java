package com.ggumtle.ggumtle.domain.matzip;

import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.shared.entity.BaseTimeEntity;
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
@Table(name = "tbl_matzip")
@Entity
public class Matzip extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column
    private String phoneNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Double latitude;

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "matzip")
    private List<Review> reviews;

    public Matzip(String name, String address, String phoneNumber, String type, Double latitude, Double longitude, String imageUrl) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageUrl = imageUrl;
    }

    public double getAverageStar() {
        return reviews.stream()
                .mapToDouble(Review::getStars)
                .average()
                .orElse(0);
    }

    public int getReviewCounts() {
        return reviews.size();
    }
}
