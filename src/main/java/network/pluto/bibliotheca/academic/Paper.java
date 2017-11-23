package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "mag_paper")
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

    @Column
    private Integer nCitation;

    @Type(type = "text")
    @Lob
    @Column(name = "abstract")
    private String paperAbstract;

    @Type(type = "text")
    @Lob
    @Column
    private String urls;

    @Column
    private String lang;

    @Column
    private String doi;

    @Column
    private String docType;

    @Type(type = "text")
    @Lob
    @Column
    private String journalName;

    @Column
    private Integer journalId;

    @Column
    private String publisher;

    @Column
    private Integer volume;

    @Column
    private Integer issue;

    @Column
    private String pageStart;

    @Column
    private String pageEnd;
}
