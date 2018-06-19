package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.dtos.CommentWrapper;
import network.pluto.bibliotheca.models.Comment;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepositoryImpl extends QueryDslRepositorySupport implements CommentRepositoryCustom {

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    @Override
    public Map<Long, CommentWrapper> getDefaultComments(List<Long> paperIds) {
        Map<Long, CommentWrapper> commentMap = new HashMap<>();

        if (paperIds.isEmpty()) {
            return commentMap;
        }

        String sql = "select t.id, t.comment, t.member_id, t.paper_id, t.created_at, t.updated_at, t.total_count\n" +
                "from (\n" +
                "       select\n" +
                "         c.id, c.comment, c.member_id, c.paper_id, c.created_at, c.updated_at,\n" +
                "         row_number() over (partition by c.paper_id order by c.created_at desc) as row,\n" +
                "         count(c.paper_id) over (partition by c.paper_id) as total_count\n" +
                "       from comment c\n" +
                "       where c.paper_id in (:paperIds)\n" +
                "     ) t\n" +
                "where t.row < 11";

        List<Object[]> results = getEntityManager()
                .createNativeQuery(sql, Comment.WITH_TOTAL_COUNT)
                .setParameter("paperIds", paperIds)
                .getResultList();

        results.forEach(r -> {
            Comment comment = (Comment) r[0];
            long totalCount = ((BigInteger) r[1]).longValue();

            CommentWrapper wrapper = commentMap.get(comment.getPaperId());
            if (wrapper != null) {
                wrapper.getComments().add(comment);
            } else  {
                CommentWrapper newWrapper = new CommentWrapper();
                newWrapper.setPaperId(comment.getPaperId());
                newWrapper.setTotalCount(totalCount);
                newWrapper.getComments().add(comment);

                commentMap.put(newWrapper.getPaperId(), newWrapper);
            }
        });

        return commentMap;
    }

}
