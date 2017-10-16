package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import network.pluto.bibliotheca.models.Evaluation;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    long countByArticle(Article article);

    boolean existsByArticleAndCreatedBy(Article article, Member createdBy);

    List<Evaluation> findByCreatedBy(Member createdBy);
}
