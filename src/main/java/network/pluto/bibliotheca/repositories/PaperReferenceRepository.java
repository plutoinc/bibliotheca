package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.PaperReference;
import network.pluto.bibliotheca.models.PaperReferenceId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperReferenceRepository extends JpaRepository<PaperReference, PaperReferenceId> {
    long countByPaperId(long paperId);
    long countByReferenceId(long referenceId);
    Page<PaperReference> findByPaperId(long paperId, Pageable pageable);
    Page<PaperReference> findByReferenceId(long referenceId, Pageable pageable);
}
