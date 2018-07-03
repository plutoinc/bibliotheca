package network.pluto.bibliotheca.repositories.mag;

import network.pluto.bibliotheca.models.mag.FieldsOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FieldsOfStudyRepository extends JpaRepository<FieldsOfStudy, Long> {
    List<FieldsOfStudy> findByIdIn(List<Long> fosIds);
}
