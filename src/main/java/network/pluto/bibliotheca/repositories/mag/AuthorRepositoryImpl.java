package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.dtos.AffiliationDto;
import network.pluto.bibliotheca.dtos.AuthorDto;
import network.pluto.bibliotheca.models.mag.Author;
import network.pluto.bibliotheca.models.mag.PaperAuthorAffiliation;
import network.pluto.bibliotheca.models.mag.QPaperAuthorAffiliation;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AuthorRepositoryImpl extends QueryDslRepositorySupport implements AuthorRepositoryCustom {

    public AuthorRepositoryImpl() {
        super(Author.class);
    }

    @Override
    public Map<Long, List<AuthorDto>> getAuthorsByPaperIdIn(List<Long> paperIds) {
        if (paperIds.isEmpty()) {
            return new HashMap<>();
        }

        QPaperAuthorAffiliation auAf = QPaperAuthorAffiliation.paperAuthorAffiliation;
        List<PaperAuthorAffiliation> results = from(auAf)
                .join(auAf.author).fetchJoin()
                .leftJoin(auAf.affiliation).fetchJoin()
                .where(auAf.id.paperId.in(paperIds), auAf.authorSequenceNumber.lt(11))
                .fetch();

        return results.stream()
                .map(r -> {
                    AuthorDto authorDto = new AuthorDto();
                    authorDto.setPaperId(r.getId().getPaperId());
                    authorDto.setOrder(r.getAuthorSequenceNumber());
                    authorDto.setId(r.getId().getAuthorId());
                    authorDto.setName(r.getAuthor().getDisplayName());

                    if (r.getAuthor().getAuthorHIndex() != null) {
                        authorDto.setHIndex(r.getAuthor().getAuthorHIndex().getHIndex());
                    }

                    if (r.getAffiliation() != null) {
                        AffiliationDto affiliationDto = new AffiliationDto();
                        affiliationDto.setId(r.getAffiliation().getId());
                        affiliationDto.setName(r.getAffiliation().getDisplayName());
                        authorDto.setAffiliation(affiliationDto);
                    }

                    return authorDto;
                })
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(AuthorDto::getPaperId),
                        map -> {
                            map.values().forEach(list -> list.sort(Comparator.comparing(AuthorDto::getOrder)));
                            return map;
                        }));
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
