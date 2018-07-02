package network.pluto.bibliotheca.models.mag;

import lombok.Getter;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

@BatchSize(size = 50)
@Getter
@Table(schema = "mcsa", name = "author_hindex")
@Entity
public class AuthorHIndex {

    @Id
    private long authorId;

    @Column(name = "hindex")
    private Integer hIndex;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @MapsId
    private Author author;

}
