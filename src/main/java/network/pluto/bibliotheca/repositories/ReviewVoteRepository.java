package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Member;
import network.pluto.bibliotheca.models.Review;
import network.pluto.bibliotheca.models.ReviewVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {
    boolean existsByMemberAndReview(Member member, Review review);
    List<ReviewVote> findByMemberAndReviewIn(Member member, List<Review> reviews);
    void deleteByMemberAndReview(Member member, Review review);
}
