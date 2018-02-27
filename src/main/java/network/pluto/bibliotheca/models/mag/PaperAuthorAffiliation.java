package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Table(schema = "mcsa", name = "rel_paper_author_affiliation")
@Entity
public class PaperAuthorAffiliation {

    @EmbeddedId
    private PaperAuthorAffiliationId id;

    @MapsId("paperId")
    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @MapsId("authorId")
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "affiliation_id")
    private Affiliation affiliation;

    @Column
    private Integer authorSequenceNumber;

    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class PaperAuthorAffiliationId implements Serializable {

        @Column
        private long paperId;

        @Column
        private long authorId;

    }

}
