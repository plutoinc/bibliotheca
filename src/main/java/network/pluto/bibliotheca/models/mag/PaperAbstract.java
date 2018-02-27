package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(schema = "mcsa", name = "paper_abstract_inverted_index")
@Entity
public class PaperAbstract {

    @Id
    private long paperId;

    @MapsId("paperId")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @Column
    private String invertedAbstract;

}
