package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import network.pluto.bibliotheca.models.Member;
import network.pluto.bibliotheca.models.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    long countByArticle(Article article);
    boolean existsByCreatedByAndArticle(Member createdBy, Article article);
    List<Review> findByCreatedByAndArticleIn(Member createdBy, List<Article> articles);
    Page<Review> findByCreatedBy(Member createdBy, Pageable pageable);
    Page<Review> findByArticle(Article article, Pageable pageable);
    long countByCreatedBy(Member createdBy);
}
