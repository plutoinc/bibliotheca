package network.pluto.bibliotheca.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import network.pluto.bibliotheca.enums.AuthorityName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Authority extends BaseEntity implements GrantedAuthority {

    @Id
    @GeneratedValue
    private long authorityId;

    @JsonIgnore
    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    public Authority(AuthorityName name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name.name();
    }
}
