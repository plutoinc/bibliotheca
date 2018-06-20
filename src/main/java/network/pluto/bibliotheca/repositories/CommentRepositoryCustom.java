package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.dtos.CommentWrapper;

import java.util.List;
import java.util.Map;

public interface CommentRepositoryCustom {
    Map<Long, CommentWrapper> getDefaultComments(List<Long> paperIds);
}
