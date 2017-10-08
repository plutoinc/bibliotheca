package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.MemberReputation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberReputationRepository extends JpaRepository<MemberReputation, Long> {
}
