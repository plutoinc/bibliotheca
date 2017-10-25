package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"MEMBER_ID", "ARTICLE_ID"}))
@Entity
public class Evaluation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long evaluationId;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @Column
    @Embedded
    private EvaluationPoint point;

    @Column(nullable = false)
    private int vote = 0;

    @OneToMany(mappedBy = "evaluation", fetch = FetchType.LAZY)
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
