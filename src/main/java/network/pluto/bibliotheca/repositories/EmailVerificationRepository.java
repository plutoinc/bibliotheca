package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.EmailVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository extends JpaRepository<EmailVerification, Long> {
    EmailVerification findByToken(String token);
}
