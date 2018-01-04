package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Table(name = "JCR_JOURNAL")
@Entity
public class Journal {

    @Id
    private long id;

    @Column
    private String fullJournalTitle;

    @Column
    private String jcrAbbreviatedTitle;

    @Column
    private String isoAbbrTitle;

    @Column
    private String issn;

    @Column
    private String language;

    @Column
    private String country;

    @Column
    private String edition;

    @Column
    private Boolean isOpenAccess;

    @Column
    private Double journalImpactFactor;

    @Column
    private Integer issues;

    @Column
    private Integer totalCites;

    @Column
    private Double fiveYearImpactFactor;

    @Column
    private Double articleInfluenceScore;

    @Column
    private Double averageJournalImpactFactorPercentile;

    @Column
    private String citableItems;

    @Column
    private String citedHalfLife;

    @Column
    private String citingHalfLife;

    @Column
    private Double eigenfactorScore;

    @Column
    private Double immediacyIndex;

    @Column
    private Double impactFactorWithoutJournalSelfCites;

    @Column
    private Double normalizedEigenfactor;

    @Column
    private Double percentArticlesInCitableItems;
}
