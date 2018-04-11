package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaperRepository extends JpaRepository<Paper, Long> {

    List<Paper> findByIdIn(List<Long> paperIds);

    @Query(value = "select * from " +
            "  (" +
            "    select paper_reference_id from mcsa.rel_paper_reference where paper_id = :paperId " +
            "    union " +
            "    select distinct paper_reference_id from mcsa.rel_paper_reference where paper_id in (select paper_reference_id from mcsa.rel_paper_reference where paper_id = :paperId) " +
            "  ) t " +
            "join mcsa.paper p on t.paper_reference_id = p.id " +
            "order by p.citation_count desc " +
            "limit 5",
            nativeQuery = true)
    List<Paper> getRelatedPapers(@Param("paperId") long paperId);

}
