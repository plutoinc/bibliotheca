package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import network.pluto.bibliotheca.enums.AuthorType;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Author extends BaseEntity {

    @Id
    @GeneratedValue
    private long authorId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthorType type;

    @Column(nullable = false)
    private String name;

    @Column
    private String organization;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Article> articles;
}
