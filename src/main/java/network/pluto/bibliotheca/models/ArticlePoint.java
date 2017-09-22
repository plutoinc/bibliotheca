package network.pluto.bibliotheca.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class ArticlePoint {

    @Column
    private double total;

    @Column
    private double originality;

    @Column
    private double contribution;

    @Column
    private double analysis;

    @Column
    private double expressiveness;
}
