package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleRepositoryCustom {
    Page<Article> findAll(Pageable pageable);
}
