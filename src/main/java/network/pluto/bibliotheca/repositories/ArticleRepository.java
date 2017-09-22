package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
