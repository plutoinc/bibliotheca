package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@ToString(exclude = { "paper" })
@Getter
@Setter
@Entity
public class PaperKeyword {

    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "PAPER_ID")
    private Paper paper;

    @Type(type = "text")
    @Lob
    @Column(nullable = false)
    private String keyword;
}
