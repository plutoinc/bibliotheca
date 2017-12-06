package network.pluto.bibliotheca.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class PaperAuthorId implements Serializable {
    private long paper;
    private int order;
}
