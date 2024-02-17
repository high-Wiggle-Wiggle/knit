package com.ggumtle.ggumtle.infrastructure.s3.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
    PROFILE("profile"),
    MATZIP("matzip"),
    REVIEW("review");

    private final String folder;
}
