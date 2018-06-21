package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.CollectionPaper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionPaperRepository extends JpaRepository<CollectionPaper, CollectionPaper.CollectionPaperId> {
}
