package com.example.oopforhits.domain.repositories;

import com.example.oopforhits.data.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan Vinnichenko
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
