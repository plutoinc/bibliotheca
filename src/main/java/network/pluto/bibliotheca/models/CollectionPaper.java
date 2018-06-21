package network.pluto.bibliotheca.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import network.pluto.bibliotheca.models.mag.Paper;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity(name = "rel_collection_paper")
public class CollectionPaper extends BaseEntity {

    @EmbeddedId
    private CollectionPaperId id;

    @Column
    private int order;

    @Type(type = "text")
    @Lob
    @Column
    private String note;

    @MapsId("paperId")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "paper_id")
    private Paper paper;

    @EqualsAndHashCode
    @Getter
    @Setter
    @Embeddable
    public static class CollectionPaperId implements Serializable {

        @Column
        private long collectionId;

        @Column
        private long paperId;

    }

}
