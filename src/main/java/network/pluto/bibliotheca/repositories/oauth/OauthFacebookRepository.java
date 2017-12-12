package network.pluto.bibliotheca.repositories.oauth;

import network.pluto.bibliotheca.models.oauth.OauthFacebook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthFacebookRepository extends JpaRepository<OauthFacebook, Long> {
    OauthFacebook findByFacebookId(String facebookId);
}
