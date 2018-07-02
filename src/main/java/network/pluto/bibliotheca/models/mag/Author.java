package network.pluto.bibliotheca.models.mag;

import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@BatchSize(size = 50)
@Getter
@Table(schema = "mcsa", name = "author")
@Entity
public class Author {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String normalizedName;

    @Column
    private String displayName;

    @ManyToOne(fetch = FetchType.LAZY)
    private Affiliation lastKnownAffiliation;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

    // for lazy loading of one-to-one relation
    @Getter(AccessLevel.PRIVATE)
    @BatchSize(size = 50)
    @OneToMany(mappedBy = "author")
    private List<AuthorHIndex> authorHIndexHolder;

    public AuthorHIndex getAuthorHIndex() {
        if (authorHIndexHolder == null || authorHIndexHolder.size() == 0) {
            return null;
        }
        return authorHIndexHolder.get(0);
    }

}
