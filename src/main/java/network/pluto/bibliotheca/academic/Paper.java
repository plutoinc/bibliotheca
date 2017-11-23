package network.pluto.bibliotheca.academic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Paper {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paperSequence")
    @SequenceGenerator(name = "paperSequence", sequenceName = "paper_sequence", allocationSize = 1)
    @Id
    private long id;
}
