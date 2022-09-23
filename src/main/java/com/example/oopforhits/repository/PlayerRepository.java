package com.example.oopforhits.repository;

import com.example.oopforhits.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
