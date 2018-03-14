package network.pluto.bibliotheca.models.oauth;

import lombok.Getter;
import lombok.Setter;
import network.pluto.bibliotheca.models.BaseEntity;
import network.pluto.bibliotheca.models.Member;

import javax.persistence.*;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@Entity
public class OauthFacebook extends BaseEntity {

    @SequenceGenerator(name = "oauthSequence", sequenceName = "oauth_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "oauthSequence")
    @Id
    private long id;

    @Column(nullable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String facebookId;

    @Column(nullable = false)
    private String accessToken;

    @Column(nullable = false)
    private boolean connected = false;

    @Transient
    private Map<String, Object> userData;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", unique = true)
    private Member member;
}
