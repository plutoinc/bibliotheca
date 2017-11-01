package network.pluto.bibliotheca.repositories;

import com.querydsl.jpa.JPQLQuery;
import network.pluto.bibliotheca.models.Article;
import network.pluto.bibliotheca.models.QArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.List;

public class ArticleRepositoryImpl extends QueryDslRepositorySupport implements ArticleRepositoryCustom {

    public ArticleRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        QArticle article = QArticle.article;

        JPQLQuery<Article> query = from(article);
        List<Article> articles = getQuerydsl().applyPagination(pageable, query).fetch();

        return new PageImpl<>(articles, pageable, query.fetchCount());
    }
}
