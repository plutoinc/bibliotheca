package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.ReputationChangeReason;

import javax.persistence.*;

@ToString(exclude = { "member" })
@Getter
@Setter
@Entity
public class MemberReputation extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberReputationSequence")
    @SequenceGenerator(name = "memberReputationSequence", sequenceName = "member_reputation_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ReputationChangeReason reason;

    @Column(nullable = false)
    private long delta = 0;
}
