package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@IdClass(RelPaperReference.RelPaperReferenceId.class)
@Table(schema = "mcsa", name = "rel_paper_reference")
@Entity
public class RelPaperReference {

    @Id
    private long paperId;

    @Id
    private long paperReferenceId;

    @EqualsAndHashCode
    @Getter
    @Setter
    public static class RelPaperReferenceId implements Serializable {
        private long paperId;
        private long paperReferenceId;
    }

}
