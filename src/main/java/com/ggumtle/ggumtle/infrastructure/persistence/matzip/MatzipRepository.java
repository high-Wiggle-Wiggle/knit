package com.ggumtle.ggumtle.infrastructure.persistence.matzip;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import org.springframework.data.repository.CrudRepository;

public interface MatzipRepository extends CrudRepository<Matzip, Long> {
}
