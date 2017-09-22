package network.pluto.bibliotheca.repositories;

import network.pluto.bibliotheca.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
