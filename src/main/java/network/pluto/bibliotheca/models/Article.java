package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import network.pluto.bibliotheca.enums.ArticleSource;
import network.pluto.bibliotheca.enums.ArticleType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Article extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long articleId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArticleType type;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "REL_ARTICLE_AUTHOR",
            joinColumns = @JoinColumn(name = "ARTICLE_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID"))
    @OrderColumn(name = "AUTHOR_ORDER")
    private List<Author> authors = new ArrayList<>();

    @Column(nullable = false)
    private String title;

    @Column
    @Lob
    private String articleAbstract;

    @Column
    @Lob
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

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Evaluation> evaluations = new ArrayList<>();
}
