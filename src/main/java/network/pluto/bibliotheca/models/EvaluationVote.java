package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString(exclude = { "member", "evaluation" })
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "MEMBER_ID", "EVALUATION_ID" }))
@Entity
public class EvaluationVote extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "EVALUATION_ID")
    private Evaluation evaluation;
}
