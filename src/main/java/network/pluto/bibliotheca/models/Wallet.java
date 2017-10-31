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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long walletId;

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
