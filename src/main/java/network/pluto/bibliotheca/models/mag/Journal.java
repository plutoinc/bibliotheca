package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(schema = "mcsa", name = "journal")
@Entity
public class Journal {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String normalizedName;

    @Column
    private String displayName;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

}
