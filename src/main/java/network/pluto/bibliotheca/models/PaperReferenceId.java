package network.pluto.bibliotheca.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class PaperReferenceId implements Serializable {
    private long paperId;
    private long referenceId;
}
