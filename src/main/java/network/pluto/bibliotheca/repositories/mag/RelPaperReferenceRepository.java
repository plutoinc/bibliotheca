package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.RelPaperReference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelPaperReferenceRepository extends JpaRepository<RelPaperReference, RelPaperReference.RelPaperReferenceId> {
    Page<RelPaperReference> findByPaperId(long paperId, Pageable pageable);
    Page<RelPaperReference> findByPaperReferenceId(long referenceId, Pageable pageable);
}
