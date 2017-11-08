package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString(exclude = { "createdBy", "article", "comments" })
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "MEMBER_ID", "ARTICLE_ID" }))
@Entity
public class Review extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewSequence")
    @SequenceGenerator(name = "reviewSequence", sequenceName = "review_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @Column
    @Embedded
    private ReviewPoint point;

    @Column(nullable = false)
    private int vote = 0;

    @OneToMany(mappedBy = "review", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    @Column(nullable = false)
    private int commentSize = 0;

    public void increaseVote() {
        ++vote;
    }

    public void increaseCommentSize() {
        ++commentSize;
    }
}
