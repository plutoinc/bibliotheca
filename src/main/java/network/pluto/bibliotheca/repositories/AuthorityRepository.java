package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.enums.AuthorityName;
import network.pluto.bibliotheca.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    Authority findByName(AuthorityName name);
}
