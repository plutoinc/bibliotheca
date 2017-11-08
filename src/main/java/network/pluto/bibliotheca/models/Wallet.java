package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.WalletStatus;

import javax.persistence.*;

@ToString(exclude = { "member", "transaction" })
@Getter
@Setter
@Entity
public class Wallet extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "walletSequence")
    @SequenceGenerator(name = "walletSequence", sequenceName = "wallet_sequence", allocationSize = 1)
    @Id
    private Long id;

    @Column
    private String address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", unique = true)
    private Member member;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'INVALID'")
    @Enumerated(EnumType.STRING)
    private WalletStatus walletStatus = WalletStatus.INVALID;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TRANSACTION_ID")
    private Transaction transaction;
}
