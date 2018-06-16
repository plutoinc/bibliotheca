package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.Paper;
import network.pluto.bibliotheca.models.mag.PaperAuthorAffiliation;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigInteger;
import java.util.List;

public interface PaperAuthorAffiliationRepository extends JpaRepository<PaperAuthorAffiliation, PaperAuthorAffiliation.PaperAuthorAffiliationId> {

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId and not r.id.paperId = :paperId order by r.authorSequenceNumber asc, r.paper.citationCount desc")
    List<Paper> getAuthorMainPapers(@Param("paperId") long paperId, @Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.citationCount desc")
    List<Paper> getAuthorPapersMostCitations(@Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.year desc")
    List<Paper> getAuthorPapersNewest(@Param("authorId") long authorId, Pageable pageable);

    @Query("select r.paper from PaperAuthorAffiliation r join r.paper where r.id.authorId = :authorId order by r.paper.year asc")
    List<Paper> getAuthorPapersOldest(@Param("authorId") long authorId, Pageable pageable);

    @Query(value = "select author_id from mcsa.rel_paper_author_affiliation where paper_id in (select paper_id from mcsa.rel_paper_author_affiliation where author_id = :authorId) and not author_id = :authorId group by author_id order by count(author_id) desc limit 5", nativeQuery = true)
    List<BigInteger> findCoAuthors(@Param("authorId") long authorId);

}
