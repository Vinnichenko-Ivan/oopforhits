package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.Team;
import com.example.oopforhits.data.model.dto.MatchDto;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import com.example.oopforhits.data.model.enums.MatchStatus;
import com.example.oopforhits.domain.repositories.MatchRepository;
import com.example.oopforhits.domain.repositories.TeamRepository;
import com.example.oopforhits.domain.services.RecordsService;
import exception.MatchNotFoundException;
import exception.TeamNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class MatchService implements RecordsService<MatchDto> {

    @Autowired
    private final MatchRepository matchRepository;

    @Autowired
    private final TeamRepository teamRepository;

    @Autowired
    private final BetManager betManager;

    @Override
    public void add(MatchDto item) {
        Match match = new Match();
        toMatch(match, item);
        matchRepository.save(match);
    }

    @Override
    public void change(MatchDto item) {
        Match match = matchRepository.findById(item.getId()).orElseThrow(MatchNotFoundException::new);
        toMatch(match, item);
        matchRepository.save(match);
    }

    @Override
    public List<MatchDto> get() {
        return matchRepository.findAll().stream().map(this::toMatchDto).collect(Collectors.toList());
    }

    @Override
    public MatchDto getById(Long id) {
        return toMatchDto(matchRepository.findById(id).orElseThrow(MatchNotFoundException::new));
    }

    @Override
    public void deleteById(Long id) {
        matchRepository.deleteById(id);
    }

    @Transactional
    public void endMatchById(Long id, EndOfMatchType endOfMatchType) {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        match.setMatchStatus(MatchStatus.ENDED);
        betManager.matchEnded(match, endOfMatchType);
    }

    @Transactional
    public void startMatchById(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        match.setMatchStatus(MatchStatus.STARTED);
        betManager.matchStarted(match);
    }

    private void toMatch(Match match, MatchDto matchDto)
    {
        Team leftTeam = teamRepository.findById(matchDto.getLeftTeamId()).orElseThrow(TeamNotFoundException::new);
        Team rightTeam = teamRepository.findById(matchDto.getRightTeamId()).orElseThrow(TeamNotFoundException::new);
        match.setLeftTeam(leftTeam);
        match.setRightTeam(rightTeam);
        match.setType(matchDto.getType());
        match.setMatchStatus(matchDto.getMatchStatus());
    }

    private MatchDto toMatchDto(Match match)
    {
        MatchDto matchDto = new MatchDto();
        matchDto.setType(match.getType());
        matchDto.setId(match.getId());
        matchDto.setLeftTeamId(match.getLeftTeam().getId());
        matchDto.setRightTeamId(match.getRightTeam().getId());
        matchDto.setMatchStatus(match.getMatchStatus());
        return matchDto;
    }

}
