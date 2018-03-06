package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MagPaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findByIdIn(List<Long> paperIds);
}
