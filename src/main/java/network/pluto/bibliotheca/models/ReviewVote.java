package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "member", "review" })
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "MEMBER_ID", "REVIEW_ID" }))
@Entity
public class ReviewVote extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewVoteSequence")
    @SequenceGenerator(name = "reviewVoteSequence", sequenceName = "review_vote_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_ID")
    private Review review;
}
