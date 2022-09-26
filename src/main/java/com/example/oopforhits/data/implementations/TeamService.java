package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.Player;
import com.example.oopforhits.data.model.Team;
import com.example.oopforhits.data.model.dto.TeamDto;
import com.example.oopforhits.domain.repositories.MatchRepository;
import com.example.oopforhits.domain.repositories.PlayerRepository;
import com.example.oopforhits.domain.repositories.TeamRepository;
import com.example.oopforhits.domain.services.RecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class TeamService implements RecordsService<TeamDto> {

    @Autowired
    private final TeamRepository teamRepository;

    @Autowired
    private final PlayerRepository playerRepository;

    @Autowired
    private final MatchRepository matchRepository;

    @Override
    public void add(TeamDto item) {
        Team team = new Team();

        Set<Match> teamMatchesSet = new HashSet<>();
        for (long matchId : item.getMatchesIdSet()) {
            teamMatchesSet.add(matchRepository.getReferenceById(matchId));
        }

        Set<Player> playersSet = new HashSet<>();
        for (long playerId : item.getPlayersIdSet()) {
            playersSet.add(playerRepository.getReferenceById(playerId));
        }

        team.setMatches(teamMatchesSet);
        team.setPlayers(playersSet);
        team.setName(item.getName());
        teamRepository.save(team);
    }

    @Override
    public void change(TeamDto item) {

    }

    @Override
    public List<TeamDto> get() {
        return null;
    }

    @Override
    public TeamDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
