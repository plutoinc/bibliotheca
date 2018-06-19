package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@SqlResultSetMapping(name = Comment.WITH_TOTAL_COUNT,
        entities = { @EntityResult(entityClass = Comment.class) },
        columns = { @ColumnResult(name = "total_count") })
@Getter
@Setter
@Entity
public class Comment extends BaseEntity {

    public static final String WITH_TOTAL_COUNT = "Comment.withTotalCount";

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "commentSequence")
    @SequenceGenerator(name = "commentSequence", sequenceName = "comment_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member createdBy;

    @Column
    private Long paperId;

    @Type(type = "text")
    @Lob
    @Column(nullable = false)
    private String comment;

}
