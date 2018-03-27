package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Bookmark.BookmarkId> {
    Page<Bookmark> findByMemberId(long memberId, Pageable pageable);
    List<Bookmark> findByMemberIdAndPaperIdIn(long memberId, List<Long> paperIds);
}
