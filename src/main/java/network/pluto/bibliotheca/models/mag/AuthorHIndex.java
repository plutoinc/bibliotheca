package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Table(schema = "mcsa", name = "author_hindex")
@Entity
public class AuthorHIndex {

    @Id
    private long authorId;


    @Column(name = "hindex")
    private Integer hIndex;

}
