package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@ToString(exclude = { "createdBy", "review" })
@Getter
@Setter
@Entity
public class Comment extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    @SequenceGenerator(name = "commentSequence", sequenceName = "comment_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_ID")
    private Review review;

    @Column
    private Long paperId;

    @Type(type = "text")
    @Lob
    @Column(nullable = false)
    private String comment;
}
