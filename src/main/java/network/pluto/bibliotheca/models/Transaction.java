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

    @Column(nullable = false, columnDefinition = "varchar(32) default 'TX_REQUESTED'")
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;

    @Column
    private String transactionData;
}
