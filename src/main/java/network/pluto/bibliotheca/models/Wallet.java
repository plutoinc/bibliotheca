package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Wallet extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long walletId;

    @Column(nullable = false)
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", unique = true)
    private Member member;
}
