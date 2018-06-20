package network.pluto.bibliotheca.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto {
    private long paperId;
    private long id;
    private String name;
    private Integer hIndex;
    private AffiliationDto affiliation;
    private int order;
}
