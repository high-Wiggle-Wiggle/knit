package com.ggumtle.ggumtle.domain.matzip.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MatzipType {

    JAPANESE("일식"),
    MEAT("고기"),
    PIZZA("피자"),
    SOUP("국물"),
    WESTERN("양식"),
    CHINESE("중식"),
    ASIAN("아시안"),
    CHICKEN("치킨"),
    RICE("밥"),
    BURGER("버거"),
    SNACK("분식"),
    CAFE("카페"),
    PORK("족발,보쌈");

    private final String name;
}
