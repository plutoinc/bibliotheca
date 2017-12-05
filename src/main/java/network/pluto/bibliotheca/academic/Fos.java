package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Fos {

    @Id
    private long id;

    @Column
    private String fos;
}
