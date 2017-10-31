package network.pluto.bibliotheca.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@ToString
@Getter
@Setter
@Embeddable
public class ArticlePoint {

    @Column
    private Double total;

    @Column
    private Double originality;

    @Column
    private Double significance;

    @Column
    private Double validity;

    @Column
    private Double organization;

    public void updateTotal() {
        double total = originality + significance + validity + organization;
        this.total = total / 4;
    }
}
