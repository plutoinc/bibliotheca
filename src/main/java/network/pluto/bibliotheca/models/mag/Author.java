package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private AuthorHIndex authorHIndex;

}
