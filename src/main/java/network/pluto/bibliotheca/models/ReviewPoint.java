package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@ToString
@Getter
@Setter
@Embeddable
public class ReviewPoint {

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int originality;

    @Column(nullable = false)
    private int significance;

    @Column(nullable = false)
    private int validity;

    @Column(nullable = false)
    private int organization;

    @Type(type = "text")
    @Lob
    @Column
    private String review;

    public void updateTotal() {
        double total = originality + significance + validity + organization;
        this.total = total / 4.0;
    }
}
