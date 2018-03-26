package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.mag.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByIdIn(List<Long> journalIds);
}
