package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Orcid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcidRepository extends JpaRepository<Orcid, Long> {
    Orcid findByOrcid(String orcid);
}
