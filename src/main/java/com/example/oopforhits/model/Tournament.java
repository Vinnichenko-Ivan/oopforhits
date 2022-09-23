package com.example.oopforhits.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
}
