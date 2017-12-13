package network.pluto.bibliotheca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@ToString(exclude = { "authorities", "wallet" })
@Getter
@Setter
@Entity
public class Member extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberSequence")
    @SequenceGenerator(name = "memberSequence", sequenceName = "member_sequence", allocationSize = 1)
    @Id
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column
    private String password;

    @JsonIgnore
    @BatchSize(size = 10)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "REL_MEMBER_AUTHORITY",
            joinColumns = @JoinColumn(name = "MEMBER_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID"))
    private List<Authority> authorities;

    @Column(nullable = false)
    private String name;

    @Column
    private String profileImage;

    @Column
    private String institution;

    @Column
    private String major;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
    private Wallet wallet;

    @Column(nullable = false)
    private long reputation = 0;

    public void changeReputation(long point) {
        reputation += point;
    }
}
