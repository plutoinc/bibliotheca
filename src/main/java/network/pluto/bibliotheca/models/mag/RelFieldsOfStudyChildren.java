package network.pluto.bibliotheca.models.mag;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@IdClass(RelFieldsOfStudyChildren.RelFieldsOfStudyChildrenId.class)
@Table(schema = "mcsa", name = "rel_fields_of_study_children")
@Entity
public class RelFieldsOfStudyChildren {

    @Id
    private long fosId;

    @Id
    private long childFosId;

    @EqualsAndHashCode
    @Getter
    @Setter
    public static class RelFieldsOfStudyChildrenId implements Serializable {
        private long fosId;
        private long childFosId;
    }

}
