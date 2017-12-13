package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "paper" })
@Getter
@Setter
@IdClass(PaperKeywordId.class)
@Entity
public class PaperKeyword {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAPER_ID")
    @Id
    private Paper paper;

    @Id
    private String keyword;
}
