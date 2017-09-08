package network.pluto.bibliotheca.models;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long walletId;

    private String address;

    @Getter
    private Date createDate;
    @Getter
    private Date updateDate;

    @PrePersist
    private void onCreate() {
        this.createDate = new Date();
    }

    @PreUpdate
    private void onUpdate() {
        this.updateDate = new Date();
    }
}
