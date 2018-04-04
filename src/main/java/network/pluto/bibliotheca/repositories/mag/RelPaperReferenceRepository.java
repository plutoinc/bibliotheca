package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.RelPaperReference;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelPaperReferenceRepository extends JpaRepository<RelPaperReference, RelPaperReference.RelPaperReferenceId> {
    List<RelPaperReference> findByPaperId(long paperId, Pageable pageable);
    List<RelPaperReference> findByPaperReferenceId(long referenceId, Pageable pageable);
}
