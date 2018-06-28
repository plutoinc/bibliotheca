package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.CollectionPaper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollectionPaperRepository extends JpaRepository<CollectionPaper, CollectionPaper.CollectionPaperId> {
    List<CollectionPaper> findByIdCollectionId(long collectionId);
    int countByIdCollectionId(long collectionId);
    void deleteByIdCollectionIdAndIdPaperIdIn(long collectionId, List<Long> paperIds);
    void deleteByIdCollectionId(long collectionId);
}
