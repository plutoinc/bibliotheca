package network.pluto.bibliotheca.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class PaperKeywordId implements Serializable {
    private long paper;
    private long keyword;
}
