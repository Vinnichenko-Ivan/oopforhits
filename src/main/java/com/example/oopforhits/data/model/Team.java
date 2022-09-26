package com.example.oopforhits.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Ivan Vinnichenko
 */

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    @ManyToMany()
    @JoinTable(
            name = "players_team",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private Set<Player> players;

    @Getter
    @Setter
    @OneToMany
    private Set<Match> matches;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;
}
