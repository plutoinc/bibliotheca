package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class Wallet extends BaseEntity {

    @Id
    @GeneratedValue
    private Long walletId;

    @Column(nullable = false)
    private String address;
}
