package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.pluto.bibliotheca.enums.TransactionStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString(exclude = { "member" })
@Getter
@Setter
@Entity
public class Transaction {
    @GenericGenerator(
            name = "transactionSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "TRANSACTION_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            }
    )
    @Id
    @GeneratedValue(generator = "transactionSequenceGenerator")
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
