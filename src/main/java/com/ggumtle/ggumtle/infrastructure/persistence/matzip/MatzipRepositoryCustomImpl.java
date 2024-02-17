package com.ggumtle.ggumtle.infrastructure.persistence.matzip;

import com.ggumtle.ggumtle.domain.matzip.Matzip;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.ggumtle.ggumtle.domain.matzip.QMatzip.matzip;

public class MatzipRepositoryCustomImpl extends QuerydslRepositorySupport implements MatzipRepositoryCustom {

    public MatzipRepositoryCustomImpl() {
        super(Matzip.class);
    }

    @Override
    public List<Matzip> searchMatzip(String q) {
        return from(matzip)
                .where(inSearchValue(q))
                .fetch();
    }

    private BooleanExpression inSearchValue(String q) {
        if (q == null || q.isEmpty()) {
            return null;
        }

        return matzip.name.contains(q).or(
                matzip.address.contains(q)).or(
                matzip.type.contains(q));
    }
}
