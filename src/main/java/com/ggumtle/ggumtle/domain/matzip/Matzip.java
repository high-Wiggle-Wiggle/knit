package com.ggumtle.ggumtle.domain.matzip;

import com.ggumtle.ggumtle.domain.matzip.enums.MatzipType;
import com.ggumtle.ggumtle.shared.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_matzip")
@Entity
public class Matzip extends BaseTimeEntity {

    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MatzipType type;

    public Matzip(String name, String address, String phoneNumber, MatzipType type) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.type = type;
    }
}
