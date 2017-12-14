package network.pluto.bibliotheca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.AuthorityName;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
public class Authority extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authoritySequence")
    @SequenceGenerator(name = "authoritySequence", sequenceName = "authority_sequence", allocationSize = 1)
    @Id
    private long id;

    @JsonIgnore
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private AuthorityName name;
}
