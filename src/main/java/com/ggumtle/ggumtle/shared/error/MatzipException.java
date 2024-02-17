package com.ggumtle.ggumtle.shared.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MatzipException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
