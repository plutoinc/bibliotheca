package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.Author;
import network.pluto.bibliotheca.models.mag.PaperAuthorAffiliation;

import java.util.List;

public interface AuthorRepositoryCustom {
    List<PaperAuthorAffiliation> getAuthorsByPaperIdIn(List<Long> paperIds);
    List<Author> findCoAuthors(long authorId);
}
