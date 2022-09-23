package com.example.oopforhits.model;

import com.example.oopforhits.model.enums.MatchType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */

@Entity
@Table(name = "teams")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private UUID id;

    @Getter
    @Setter
    private MatchType type;

    @Getter
    @Setter
    @ManyToOne()
    @JoinColumn(name = "left_team_id")
    private Team leftTeam;

}
