package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Evaluation;
import network.pluto.bibliotheca.models.EvaluationVote;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EvaluationVoteRepository extends JpaRepository<EvaluationVote, Long> {
    boolean existsByMemberAndEvaluation(Member member, Evaluation evaluation);

    @Query("select e.evaluation.evaluationId from EvaluationVote e where e.member.memberId = :memberId and e.evaluation.evaluationId in :evaluationIds")
    List<Long> getVotedEvaluationIds(@Param("memberId") long memberId, @Param("evaluationIds") List<Long> evaluationIds);
}
