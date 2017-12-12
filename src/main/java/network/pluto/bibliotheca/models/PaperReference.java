package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@IdClass(PaperReferenceId.class)
@Table(name = "REL_PAPER_REFERENCE")
@Entity
public class PaperReference {

    @Id
    private long paperId;

    @Column(name = "REFERENCE_PAPER_ID")
    @Id
    private long referenceId;
}
