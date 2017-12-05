package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@IdClass(PaperAuthorId.class)
@Entity
public class PaperAuthor {

    @ManyToOne
    @JoinColumn(name = "PAPER_ID")
    @Id
    private Paper paper;

    @Id
    private int ord;

    @Column
    private String name;

    @Column
    private String org;
}
