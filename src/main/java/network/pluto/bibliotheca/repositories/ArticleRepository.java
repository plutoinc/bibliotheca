package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>, QueryDslPredicateExecutor<Article>, ArticleRepositoryCustom {
    Page<Article> findByCreatedBy(Member createdBy, Pageable pageable);
    Page<Article> findByIdIn(List<Long> articleIds, Pageable pageable);
    long countByCreatedBy(Member createdBy);
}
