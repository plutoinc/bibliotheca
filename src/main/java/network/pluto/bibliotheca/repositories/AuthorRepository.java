package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
