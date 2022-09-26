package com.example.oopforhits.domain.repositories;

import com.example.oopforhits.data.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
