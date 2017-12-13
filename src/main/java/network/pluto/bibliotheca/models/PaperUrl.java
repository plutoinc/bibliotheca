package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "paper" })
@Getter
@Setter
@Entity
public class PaperUrl {

    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PAPER_ID")
    private Paper paper;

    @Column(nullable = false)
    private String url;
}
