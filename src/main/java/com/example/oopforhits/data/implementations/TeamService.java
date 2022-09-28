package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Player;
import com.example.oopforhits.data.model.Team;
import com.example.oopforhits.data.model.dto.TeamDto;
import com.example.oopforhits.domain.repositories.PlayerRepository;
import com.example.oopforhits.domain.repositories.TeamRepository;
import com.example.oopforhits.domain.services.RecordsService;
import exception.PlayerNotFoundException;
import exception.TeamNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class TeamService implements RecordsService<TeamDto> {

    @Autowired
    private final PlayerRepository playerRepository;
    @Autowired
    private final TeamRepository teamRepository;

    @Override
    public void add(TeamDto item) {
        Team team = new Team();
        toTeam(team, item);
        teamRepository.save(team);
    }

    @Override
    public void change(TeamDto item) {
        Team team = teamRepository.findById(item.getId()).orElseThrow(TeamNotFoundException::new);
        toTeam(team, item);
        teamRepository.save(team);
    }

    @Override
    public List<TeamDto> get() {
        return teamRepository.findAll().stream().map(this::toTeamDto).collect(Collectors.toList());
    }

    @Override
    public TeamDto getById(Long id) {
        return toTeamDto(teamRepository.findById(id).orElseThrow(TeamNotFoundException::new));
    }

    @Override
    public void deleteById(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new TeamNotFoundException();
        }
    }

    private void toTeam(Team team, TeamDto teamDto) {
        team.setName(teamDto.getName());
        Set<Player> players = new HashSet<>();
        if (teamDto.getPlayersId() != null) {
            for (Long playerId : teamDto.getPlayersId()) {
                Player player = playerRepository.findById(playerId)
                        .orElseThrow(PlayerNotFoundException::new);
                players.add(player);
                team.setPlayers(players);
            }
        }
    }

    private TeamDto toTeamDto(Team team) {
        TeamDto teamDto = new TeamDto(team.getName());
        teamDto.setId(team.getId());
        Set<Long> playersId = new HashSet<>();
        for (Player player : team.getPlayers()) {
            playersId.add(player.getId());
        }
        teamDto.setPlayersId(playersId);
        return teamDto;
    }

}
