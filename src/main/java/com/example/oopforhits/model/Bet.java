package com.example.oopforhits.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Entity
@Table(name = "bets")
public class Bet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private UUID id;
}
