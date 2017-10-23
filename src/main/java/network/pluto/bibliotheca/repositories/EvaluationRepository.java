package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import network.pluto.bibliotheca.models.Evaluation;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    long countByArticle(Article article);

    boolean existsByCreatedByAndArticle(Member createdBy, Article article);

    List<Evaluation> findByCreatedByAndArticleIn(Member createdBy, List<Article> articles);

    Page<Evaluation> findByCreatedBy(Member createdBy, Pageable pageable);

    Page<Evaluation> findByArticle(Article article, Pageable pageable);
}
