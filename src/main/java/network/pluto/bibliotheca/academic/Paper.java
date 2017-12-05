package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Paper {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paperSequence")
    @SequenceGenerator(name = "paperSequence", sequenceName = "paper_sequence", allocationSize = 1)
    @Id
    private long id;

    @Column(nullable = false)
    private String magId;

    @Type(type = "text")
    @Lob
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    @Column(name = "n_citation")
    private Integer citation;

    @Type(type = "text")
    @Lob
    @Column(name = "abstract")
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "REL_PAPER_FOS",
            joinColumns = @JoinColumn(name = "PAPER_ID"),
            inverseJoinColumns = @JoinColumn(name = "FOS_ID"))
    private List<Fos> fosList = new ArrayList<>();

    @OneToMany(mappedBy = "paper", fetch = FetchType.LAZY)
    private List<PaperAuthor> authors = new ArrayList<>();
}
