package network.pluto.bibliotheca.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class EvaluationPoint {

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int originality;

    @Column(nullable = false)
    private int contribution;

    @Column(nullable = false)
    private int analysis;

    @Column(nullable = false)
    private int expressiveness;

    @Column
    private String originalityComment;

    @Column
    private String contributionComment;

    @Column
    private String analysisComment;

    @Column
    private String expressivenessComment;
}
