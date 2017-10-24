package network.pluto.bibliotheca.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
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
