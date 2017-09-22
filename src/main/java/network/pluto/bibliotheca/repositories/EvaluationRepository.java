package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
}
