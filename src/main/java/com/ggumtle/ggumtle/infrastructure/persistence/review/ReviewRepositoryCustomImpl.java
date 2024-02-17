package com.ggumtle.ggumtle.infrastructure.persistence.review;

import com.ggumtle.ggumtle.domain.review.Review;
import com.ggumtle.ggumtle.domain.user.QUser;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPAExpressions;
import org.hibernate.query.criteria.JpaExpression;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

import static com.ggumtle.ggumtle.domain.follow.QFollow.follow;
import static com.ggumtle.ggumtle.domain.matzip.QMatzip.matzip;
import static com.ggumtle.ggumtle.domain.review.QReview.review;
import static com.ggumtle.ggumtle.domain.user.QUser.user;

public class ReviewRepositoryCustomImpl extends QuerydslRepositorySupport implements ReviewRepositoryCustom {

    public ReviewRepositoryCustomImpl() {
        super(Review.class);
    }

    @Override
    public List<Review> searchReview(String q) {
        return from(review)
                .innerJoin(review.user, user)
                .innerJoin(review.matzip, matzip)
                .where(inSearchValue(q))
                .orderBy(review.id.desc())
                .fetch();
    }

    private BooleanExpression inSearchValue(String q) {
        if (q == null || q.isBlank()) {
            return null;
        }

        return review.content.contains(q).or(
                user.name.contains(q).or(
                        matzip.name.contains(q).or(
                                matzip.address.contains(q).or(
                                        matzip.type.contains(q)
                                ))));
    }

    @Override
    public List<Review> getFeed(Long userId) {
        return from(review)
                .where(review.user.id.in(
                        JPAExpressions.select(follow.followee.id)
                                .from(follow)
                                .where(follow.follower.id.eq(userId))
                ))
                .orderBy(review.id.desc())
                .fetch();
    }
}
