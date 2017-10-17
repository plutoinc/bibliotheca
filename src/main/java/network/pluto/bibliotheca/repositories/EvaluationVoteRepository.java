package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Evaluation;
import network.pluto.bibliotheca.models.EvaluationVote;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationVoteRepository extends JpaRepository<EvaluationVote, Long> {
    boolean existsByMemberAndEvaluation(Member member, Evaluation evaluation);

    List<EvaluationVote> findByMemberAndEvaluationIn(Member member, List<Evaluation> evaluations);
}
