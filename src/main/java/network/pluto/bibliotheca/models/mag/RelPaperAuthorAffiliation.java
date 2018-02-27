package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@IdClass(RelPaperAuthorAffiliation.RelPaperAuthorAffiliationId.class)
@Table(schema = "mcsa", name = "rel_paper_author_affiliation")
@Entity
public class RelPaperAuthorAffiliation {

    @Id
    private long paperId;

    @Id
    private long authorId;

    @Column
    private Long affiliationId;

    @Column
    private Integer authorSequenceNumber;

    @EqualsAndHashCode
    @Getter
    @Setter
    public static class RelPaperAuthorAffiliationId implements Serializable {
        private long paperId;
        private long authorId;
    }

}
