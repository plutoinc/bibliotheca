package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.ArticleSource;
import network.pluto.bibliotheca.enums.ArticleType;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = { "createdBy", "authors", "reviews" })
@Getter
@Setter
@Entity
public class Article extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articleSequence")
    @SequenceGenerator(name = "articleSequence", sequenceName = "article_sequence", allocationSize = 1)
    @Id
    private long articleId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

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

    @Type(type = "text")
    @Lob
    @Column
    private String summary;

    @Column
    private String link;

    @Column
    @Enumerated(EnumType.STRING)
    private ArticleSource source;

    @Type(type = "text")
    @Lob
    @Column
    private String note;

    @Column
    @Embedded
    private ArticlePoint point;

    @Column
    private LocalDateTime articlePublishedAt;

    @Column
    private LocalDateTime articleUpdatedAt;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<Review> reviews = new ArrayList<>();

    @Column(nullable = false)
    private int reviewSize = 0;

    public void increaseReviewSize() {
        ++reviewSize;
    }
}
