package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Evaluation extends BaseEntity {

    @Id
    @GeneratedValue
    private long evaluationId;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    @Column
    private double total;

    @Column
    private double originality;

    @Column
    private double contribution;

    @Column
    private double analysis;

    @Column
    private double expressiveness;

    @Column
    private String originalityComment;

    @Column
    private String contributionComment;

    @Column
    private String analysisComment;

    @Column
    private String expressivenessComment;

    @OneToMany(mappedBy = "evaluation")
    private List<Comment> comments;
}
