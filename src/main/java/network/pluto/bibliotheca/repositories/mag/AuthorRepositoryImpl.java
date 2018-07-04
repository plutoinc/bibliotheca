package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.Author;
import network.pluto.bibliotheca.models.mag.PaperAuthorAffiliation;
import network.pluto.bibliotheca.models.mag.QPaperAuthorAffiliation;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl extends QueryDslRepositorySupport implements AuthorRepositoryCustom {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }

    @Override
    public List<PaperAuthorAffiliation> getAuthorsByPaperIdIn(List<Long> paperIds) {
        if (paperIds.isEmpty()) {
            return new ArrayList<>();
        }

        QPaperAuthorAffiliation auAf = QPaperAuthorAffiliation.paperAuthorAffiliation;
        return from(auAf)
                .where(auAf.id.paperId.in(paperIds), auAf.authorSequenceNumber.lt(11))
                .fetch();
    }

    @Override
    public List<Author> findCoAuthors(long authorId) {
        String sql =
                "select a.*\n" +
                        "from\n" +
                        "  (\n" +
                        "    select r1.author_id as id\n" +
                        "    from\n" +
                        "      mcsa.rel_paper_author_affiliation r1\n" +
                        "    where\n" +
                        "      r1.paper_id in (\n" +
                        "        select r2.paper_id\n" +
                        "        from\n" +
                        "          mcsa.rel_paper_author_affiliation r2\n" +
                        "          join mcsa.paper p on r2.paper_id = p.id\n" +
                        "        where\n" +
                        "          r2.author_id = :authorId\n" +
                        "          and r2.author_sequence_number < 10\n" +
                        "        order by p.citation_count desc\n" +
                        "        limit 10\n" +
                        "      )\n" +
                        "      and r1.author_id <> :authorId\n" +
                        "      and r1.author_sequence_number < 10\n" +
                        "    group by r1.author_id\n" +
                        "    order by count(r1.author_id) desc\n" +
                        "    limit 5\n" +
                        "  ) t\n" +
                        "  join mcsa.author a on t.id = a.id;";

        List<Author> results = getEntityManager()
                .createNativeQuery(sql, Author.class)
                .setParameter("authorId", authorId)
                .getResultList();

        return results;
    }

}
