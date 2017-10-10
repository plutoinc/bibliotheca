package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import network.pluto.bibliotheca.enums.AuthorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Author extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long authorId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuthorType type;

    @Column(nullable = false)
    private String name;

    @Column
    private String institution;

    @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Article> articles = new ArrayList<>();
}
