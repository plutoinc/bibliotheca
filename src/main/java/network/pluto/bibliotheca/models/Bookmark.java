package network.pluto.bibliotheca.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Getter
@Setter
@IdClass(Bookmark.BookmarkId.class)
@Entity
public class Bookmark extends BaseEntity {

    @Id
    private long memberId;

    @Id
    private long paperId;

    @EqualsAndHashCode
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    @AllArgsConstructor(staticName = "of")
    public static class BookmarkId implements Serializable {
        private long memberId;
        private long paperId;
    }

}
