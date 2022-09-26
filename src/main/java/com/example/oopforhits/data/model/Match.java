package com.example.oopforhits.data.model;

import com.example.oopforhits.data.model.enums.MatchType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Ivan Vinnichenko
 */

@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "type")
    private MatchType type;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "left_team_id")
    private Team leftTeam;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "right_team_id")
    private Team rightTeam;
}
