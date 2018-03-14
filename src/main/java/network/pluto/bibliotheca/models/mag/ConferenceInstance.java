package network.pluto.bibliotheca.models.mag;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(schema = "mcsa", name = "conference_instance")
@Entity
public class ConferenceInstance {

    @Id
    private long id;

    @Column
    private Long rank;

    @Column
    private String normalizedName;

    @Column
    private String displayName;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConferenceSeries conferenceSeries;

    @Column
    private String location;

    @Column
    private String officialUrl;

    @Column
    private String startDate;

    @Column
    private String endDate;

    @Column
    private String abstractRegistrationDate;

    @Column
    private String submissionDeadlineDate;

    @Column
    private String notificationDueDate;

    @Column
    private String finalVersionDueDate;

    @Column
    private Long paperCount;

    @Column
    private Long citationCount;

}
