package network.pluto.bibliotheca.repositories.mag;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import network.pluto.bibliotheca.models.mag.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@XRayEnabled
public interface AuthorRepository extends JpaRepository<Author, Long>, AuthorRepositoryCustom {
    List<Author> findByIdIn(List<Long> authorIds);
}
