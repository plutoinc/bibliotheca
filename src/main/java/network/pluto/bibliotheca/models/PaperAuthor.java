package network.pluto.bibliotheca.models;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAPER_ID")
    @Id
    private Paper paper;

    @Id
    @Column(name = "ORD")
    private int order;

    @Column(nullable = false)
    private String name;

    @Column(name = "ORG")
    private String organization;
}
