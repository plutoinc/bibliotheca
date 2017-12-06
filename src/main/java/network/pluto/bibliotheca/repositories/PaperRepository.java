package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Paper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findByIdIn(List<Long> paperIds);
}
