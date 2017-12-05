package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "paper" })
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
