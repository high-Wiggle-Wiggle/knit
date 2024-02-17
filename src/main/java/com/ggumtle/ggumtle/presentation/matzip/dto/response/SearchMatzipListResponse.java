package com.ggumtle.ggumtle.presentation.matzip.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SearchMatzipListResponse {

    private List<MatzipResponse> matzipList;
}
