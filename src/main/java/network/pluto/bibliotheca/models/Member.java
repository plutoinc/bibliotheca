package network.pluto.bibliotheca.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "PLUTO_MEMBER")
public class Member {
    @Id
    @GeneratedValue
    private long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "MEMBER_ID", referencedColumnName = "memberId"),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "authorityId"))
    private List<Authority> authorities;

    @Column
    private String nickName;
}
