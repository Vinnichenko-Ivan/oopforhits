package com.example.oopforhits.data.model;

import com.example.oopforhits.data.model.enums.BetType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    @Column(name = "bet_value")
    private Double value;

    @Getter
    @Setter
    @Column(name = "ratio")
    private Double ratio;

    @Getter
    @Setter
    @Column(name = "bet_type")
    private BetType betType;

    @Getter
    @Setter
    @ManyToOne
    private Match match;
}
