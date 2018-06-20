package network.pluto.bibliotheca.dtos;

import lombok.Getter;
import lombok.Setter;
import network.pluto.bibliotheca.models.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommentWrapper {
    private long paperId;
    private long totalCount;
    private List<Comment> comments = new ArrayList<>();
}
