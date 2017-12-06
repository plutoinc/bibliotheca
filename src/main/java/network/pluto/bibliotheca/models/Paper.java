package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = { "fosList", "authors" })
@Getter
@Setter
@Entity
public class Paper {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paperSequence")
    @SequenceGenerator(name = "paperSequence", sequenceName = "paper_sequence", allocationSize = 1)
    @Id
    private long id;

    @Column
    private String magId;

    @Type(type = "text")
    @Lob
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer year;

    @Column(name = "N_CITATION")
    private Integer citation;

    @Type(type = "text")
    @Lob
    @Column(name = "ABSTRACT")
    private String paperAbstract;

    @Column
    private String lang;

    @Column
    private String doi;

    @Column
    private String publisher;

    @Column
    private String venue;

    @Column
    private Integer volume;

    @Column
    private Integer issue;

    @Column
    private String pageStart;

    @Column
    private String pageEnd;

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperAuthor> authors = new ArrayList<>();

    @LazyCollection(LazyCollectionOption.EXTRA)
    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper")
    private List<PaperKeyword> keywords = new ArrayList<>();

    @BatchSize(size = 10)
    @ManyToMany
    @JoinTable(name = "REL_PAPER_FOS",
            joinColumns = @JoinColumn(name = "PAPER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOS_ID"))
    private List<Fos> fosList = new ArrayList<>();

    @BatchSize(size = 10)
    @OneToMany(mappedBy = "paper", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
}
