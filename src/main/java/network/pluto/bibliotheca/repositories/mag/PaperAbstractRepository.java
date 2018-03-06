package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.PaperAbstract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaperAbstractRepository extends JpaRepository<PaperAbstract, Long> {
    List<PaperAbstract> findByPaperIdIn(List<Long> paperIds);
}
