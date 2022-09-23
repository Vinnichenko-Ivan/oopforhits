package com.example.oopforhits.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private UUID id;

    @Getter
    @Setter
    @ManyToMany()
    private Set<Player> players;

    @Getter
    @Setter
    @OneToMany
    private Set<Match> matches;
}
