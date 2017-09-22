package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import network.pluto.bibliotheca.enums.ArticleSource;
import network.pluto.bibliotheca.enums.ArticleType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Article extends BaseEntity {

    @Id
    @GeneratedValue
    private long articleId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column
    @Enumerated(EnumType.STRING)
    private ArticleType type;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "REL_ARTICLE_AUTHOR",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    @OrderColumn(name = "AUTHOR_ORDER")
    private List<Author> authors;

    @Column
    private String title;

    @Column
    private String articleAbstract;

    @Column
    private String summary;

    @Column
    private String link;

    @Column
    @Enumerated(EnumType.STRING)
    private ArticleSource source;

    @Column
    @Embedded
    private ArticlePoint point;

    @Column
    private LocalDateTime articlePublishedAt;

    @Column
    private LocalDateTime articleUpdatedAt;
}
