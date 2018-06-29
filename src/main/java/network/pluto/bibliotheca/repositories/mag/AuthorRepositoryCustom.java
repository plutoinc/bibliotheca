package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.dtos.AuthorDto;
import network.pluto.bibliotheca.models.mag.Author;

import java.util.List;
import java.util.Map;

public interface AuthorRepositoryCustom {
    Map<Long, List<AuthorDto>> getAuthorsByPaperIdIn(List<Long> paperIds);
    List<Author> findCoAuthors(long authorId);
}
