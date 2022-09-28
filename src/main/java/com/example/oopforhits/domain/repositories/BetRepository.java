package com.example.oopforhits.domain.repositories;

import com.example.oopforhits.data.model.Bet;
import com.example.oopforhits.data.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findAllByMatch(Match match);
}
