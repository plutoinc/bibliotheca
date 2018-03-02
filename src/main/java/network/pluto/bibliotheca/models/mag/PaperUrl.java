package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(schema = "mcsa", name = "paper_url")
@Entity(name = "MagPaperUrl")
public class PaperUrl {

    @Id
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @Column
    private Integer sourceType;

    @Column
    private String sourceUrl;

}
