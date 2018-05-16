package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {
}
