package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@IdClass(RelPaperCitationContext.RelPaperCitationContextId.class)
@Table(schema = "mcsa", name = "rel_paper_citation_context")
@Entity
public class RelPaperCitationContext {

    @Id
    private long paperId;

    @Id
    private long paperReferenceId;

    @Column
    private String citationContext;

    @EqualsAndHashCode
    @Getter
    @Setter
    public static class RelPaperCitationContextId implements Serializable {
        private long paperId;
        private long paperReferenceId;
    }

}
