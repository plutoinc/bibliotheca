package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(schema = "mcsa", name = "paper")
@Entity
public class Paper {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String doi;

    @Column
    private String docType;

    @Column
    private String title;

    @Column
    private String originalTitle;

    @Column
    private String bookTitle;

    @Column
    private Integer year;

    @Column
    private String date;

    @Column
    private String publisher;

    @JoinColumn(name = "journal_id")
    @ManyToOne
    private Journal journal;

    @ManyToOne
    private ConferenceSeries conferenceSeries;

    @ManyToOne
    private ConferenceInstance conferenceInstance;

    @Column
    private String volume;

    @Column
    private String issue;

    @Column
    private String firstPage;

    @Column
    private String lastPage;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

    @Column
    private Integer estimatedCitation;

}
