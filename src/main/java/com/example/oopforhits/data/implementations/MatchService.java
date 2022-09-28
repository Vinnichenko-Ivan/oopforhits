package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.Team;
import com.example.oopforhits.data.model.dto.MatchDto;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import com.example.oopforhits.data.model.enums.MatchStatus;
import com.example.oopforhits.domain.repositories.MatchRepository;
import com.example.oopforhits.domain.repositories.TeamRepository;
import com.example.oopforhits.domain.services.RecordsService;
import exception.MatchIllegalStateException;
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

    @Autowired
    private final MatchMapper matchMapper;

    @Override
    public void add(MatchDto item) {
        Match match = new Match();
        toMatch(match, item);
        match.setMatchStatus(MatchStatus.PLANED);
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
        return matchRepository.findAll().stream().map(matchMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public MatchDto getById(Long id) {
        return matchMapper.toDto(matchRepository.findById(id).orElseThrow(MatchNotFoundException::new));
    }

    @Override
    public void deleteById(Long id) {
        matchRepository.deleteById(id);
    }

    @Transactional
    public void endMatchById(Long id, EndOfMatchType endOfMatchType) {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        if (match.getMatchStatus() == MatchStatus.STARTED) {
            match.setMatchStatus(MatchStatus.ENDED);
        } else {
            throw new MatchIllegalStateException();
        }
        matchRepository.save(match);
        betManager.matchEnded(match, endOfMatchType);
    }

    @Transactional
    public void startMatchById(Long id) {
        Match match = matchRepository.findById(id).orElseThrow(MatchNotFoundException::new);
        if (match.getMatchStatus() == MatchStatus.PLANED) {
            match.setMatchStatus(MatchStatus.STARTED);
        } else {
            throw new MatchIllegalStateException();
        }
        matchRepository.save(match);
        betManager.matchStarted(match);
    }

    private void toMatch(Match match, MatchDto matchDto) {
        Team leftTeam = teamRepository.findById(matchDto.getLeftTeamId()).orElseThrow(TeamNotFoundException::new);
        Team rightTeam = teamRepository.findById(matchDto.getRightTeamId()).orElseThrow(TeamNotFoundException::new);
        match.setLeftTeam(leftTeam);
        match.setRightTeam(rightTeam);
        matchMapper.fromDto(match, matchDto);
    }


}
