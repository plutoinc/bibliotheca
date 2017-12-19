package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.TransactionStatus;

import javax.persistence.*;

@ToString(exclude = { "member" })
@Getter
@Setter
@Entity
public class Transaction {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transactionSequence")
    @SequenceGenerator(name = "transactionSequence", sequenceName = "transaction_sequence", allocationSize = 1)
    @Id
    private long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus = TransactionStatus.TX_REQUESTED;

    @Column
    private String transactionData;
}
