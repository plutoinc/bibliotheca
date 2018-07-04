package network.pluto.bibliotheca.repositories.mag;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import network.pluto.bibliotheca.models.mag.Paper;
import network.pluto.bibliotheca.models.mag.PaperAuthorAffiliation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@XRayEnabled
public interface PaperAuthorAffiliationRepository extends JpaRepository<PaperAuthorAffiliation, PaperAuthorAffiliation.PaperAuthorAffiliationId> {

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId and r.id.paperId <> :paperId and r.authorSequenceNumber < 10 order by r.paper.citationCount desc")
    List<Paper> getAuthorMainPapers(@Param("paperId") long paperId, @Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.citationCount desc")
    List<Paper> getAuthorPapersMostCitations(@Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.year desc")
    List<Paper> getAuthorPapersNewest(@Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.year asc")
    List<Paper> getAuthorPapersOldest(@Param("authorId") long authorId, Pageable pageable);

}
