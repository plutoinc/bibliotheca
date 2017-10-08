package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Evaluation;
import network.pluto.bibliotheca.models.EvaluationVote;
import network.pluto.bibliotheca.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationVoteRepository extends JpaRepository<EvaluationVote, Long> {
    EvaluationVote findByMemberAndEvaluation(Member member, Evaluation evaluation);
}
