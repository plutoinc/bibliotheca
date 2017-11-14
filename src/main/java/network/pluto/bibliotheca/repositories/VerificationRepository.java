package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, Long> {
    Verification findByToken(String token);
}
