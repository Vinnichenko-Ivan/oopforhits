package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Bet;
import com.example.oopforhits.data.model.dto.BetDto;
import com.example.oopforhits.data.model.enums.BetStatus;
import com.example.oopforhits.domain.repositories.BetRepository;
import com.example.oopforhits.domain.repositories.MatchRepository;
import com.example.oopforhits.domain.services.RecordsService;
import exception.BetIsNotAcceptException;
import exception.BetIsPlayedException;
import exception.BetNotFoundException;
import exception.MatchNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class BetService implements RecordsService<BetDto> {

    @Autowired
    private final BetManager betManager;

    @Autowired
    private final BetRepository betRepository;

    @Autowired
    private final MatchRepository matchRepository;

    @Autowired
    private final BetMapper betMapper;

    @Override
    public void add(BetDto item) {
        Bet bet = new Bet();
        toBet(bet, item);
        bet.setBetStatus(BetStatus.NOT_STATE);
        if (bet.getBetStatus() == BetStatus.NOT_STATE) {
            if (betManager.betIsAccept(bet)) {
                betRepository.save(bet);
            } else {
                throw new BetIsNotAcceptException();
            }
        }
    }

    @Override
    public void change(BetDto item) {
        Bet bet = betRepository.findById(item.getId()).orElseThrow(BetNotFoundException::new);
        if (bet.getBetStatus() == BetStatus.NOT_STATE) {
            toBet(bet, item);
            if (betManager.betIsAccept(bet)) {
                betRepository.save(bet);
            } else {
                throw new BetIsNotAcceptException();
            }
        } else {
            throw new BetIsPlayedException();
        }
    }

    @Override
    public List<BetDto> get() {
        return betRepository.findAll().stream().map(betMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BetDto getById(Long id) {
        return betMapper.toDto(betRepository.findById(id).orElseThrow(BetNotFoundException::new));
    }

    @Override
    public void deleteById(Long id) {
        Bet bet = betRepository.findById(id).orElseThrow(BetNotFoundException::new);
        if (bet.getBetStatus() == BetStatus.NOT_STATE) {
            betRepository.deleteById(id);
        } else {
            throw new BetIsPlayedException();
        }
    }

    private void toBet(Bet bet, BetDto betDto) {
        betMapper.fromDto(bet, betDto);
        bet.setMatch(matchRepository.findById(betDto.getMatchId()).orElseThrow(MatchNotFoundException::new));
    }

}
