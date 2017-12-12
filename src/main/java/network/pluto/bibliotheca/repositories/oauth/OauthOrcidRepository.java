package network.pluto.bibliotheca.repositories.oauth;

import network.pluto.bibliotheca.models.oauth.OauthOrcid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OauthOrcidRepository extends JpaRepository<OauthOrcid, Long> {
    OauthOrcid findByOrcid(String orcid);
}
