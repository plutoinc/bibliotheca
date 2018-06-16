package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.dtos.AuthorDto;

import java.util.List;
import java.util.Map;

public interface AuthorRepositoryCustom {
    Map<Long, List<AuthorDto>> getAuthorsByPaperIdIn(List<Long> paperIds);
}
