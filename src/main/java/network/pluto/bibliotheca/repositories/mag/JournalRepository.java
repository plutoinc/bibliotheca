package network.pluto.bibliotheca.repositories.mag;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import network.pluto.bibliotheca.models.mag.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@XRayEnabled
public interface JournalRepository extends JpaRepository<Journal, Long> {
    List<Journal> findByIdIn(List<Long> journalIds);
}
