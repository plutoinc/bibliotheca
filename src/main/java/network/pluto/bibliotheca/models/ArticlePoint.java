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
    private Double contribution;

    @Column
    private Double analysis;

    @Column
    private Double expressiveness;
}
