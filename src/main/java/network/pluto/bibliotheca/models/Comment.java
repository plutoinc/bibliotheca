package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "createdBy", "review" })
@Getter
@Setter
@Entity
public class Comment extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    @SequenceGenerator(name = "commentSequence", sequenceName = "comment_sequence", allocationSize = 1)
    @Id
    private long commentId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_ID")
    private Review review;

    @Column(nullable = false)
    private String comment;
}
