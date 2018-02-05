package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Comment;
import network.pluto.bibliotheca.models.Member;
import network.pluto.bibliotheca.models.Paper;
import network.pluto.bibliotheca.models.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByReview(Review review, Pageable pageable);
    Page<Comment> findByPaperOrderByIdDesc(Paper paper, Pageable pageable);
    Page<Comment> findByCognitivePaperIdOrderByIdDesc(long cognitivePaperId, Pageable pageable);
    long countByCreatedBy(Member createdBy);
    long countByPaper(Paper paper);
}
