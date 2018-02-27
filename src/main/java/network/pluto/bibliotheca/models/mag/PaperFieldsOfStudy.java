package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Table(schema = "mcsa", name = "rel_paper_fields_of_study")
@Entity
public class PaperFieldsOfStudy {

    @EmbeddedId
    private PaperFieldsOfStudyId id;

    @MapsId("paperId")
    @ManyToOne
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @MapsId("fosId")
    @ManyToOne
    @JoinColumn(name = "fos_id")
    private FieldsOfStudy fieldsOfStudy;

    @Column
    private Double similarity;

    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class PaperFieldsOfStudyId implements Serializable {

        @Column
        private long paperId;

        @Column
        private long fosId;

    }

}
