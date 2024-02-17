package com.ggumtle.ggumtle.infrastructure.persistence.matzip;

import com.ggumtle.ggumtle.domain.matzip.Matzip;

import java.util.List;

public interface MatzipRepositoryCustom {

    List<Matzip> searchMatzip(String q);
}
