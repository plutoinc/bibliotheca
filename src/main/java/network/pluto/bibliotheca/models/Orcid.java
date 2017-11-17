package network.pluto.bibliotheca.models;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "member" })
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", unique = true)
    private Member member;
}
