package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

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
}
