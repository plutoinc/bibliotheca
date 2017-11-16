package network.pluto.bibliotheca.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Orcid extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orcidSequence")
    @SequenceGenerator(name = "orcidSequence", sequenceName = "orcid_sequence", allocationSize = 1)
    @Id
    private long id;

    @Column(nullable = false, unique = true)
    private String orcid;

    @Column
    private String name;

    @Column(nullable = false)
    private String accessToken;
}
