package network.pluto.bibliotheca.repositories.oauth;

import network.pluto.bibliotheca.models.oauth.OauthGoogle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthGoogleRepository extends JpaRepository<OauthGoogle, Long> {
    OauthGoogle findByGoogleId(String googleId);
}
