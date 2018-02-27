package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@IdClass(RelPaperFieldsOfStudy.RelPaperFieldsOfStudyId.class)
@Table(schema = "mcsa", name = "rel_paper_fields_of_study")
@Entity
public class RelPaperFieldsOfStudy {

    @Id
    private long paperId;

    @Id
    private long fosId;

    @Column
    private Double similarity;

    @EqualsAndHashCode
    @Getter
    @Setter
    public static class RelPaperFieldsOfStudyId implements Serializable {
        private long paperId;
        private long fosId;
    }

}
