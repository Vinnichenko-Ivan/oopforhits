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

import java.util.ArrayList;
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

    @Override
    public void add(BetDto item) {
        Bet bet = new Bet();
        toBet(bet, item);
        bet.setBetStatus(BetStatus.NOT_STATE);
        if(betManager.betIsAccept(bet))
        {
            betRepository.save(bet);
        }
        else
        {
            throw new BetIsNotAcceptException();
        }
    }

    @Override
    public void change(BetDto item) {
        Bet bet = betRepository.findById(item.getId()).orElseThrow(BetNotFoundException::new);
        if(bet.getBetStatus() == BetStatus.NOT_STATE)
        {
            toBet(bet, item);
            if(betManager.betIsAccept(bet))
            {
                betRepository.save(bet);
            }
            else
            {
                throw new BetIsNotAcceptException();
            }
        }
        else
        {
            throw new BetIsPlayedException();
        }
    }

    @Override
    public List<BetDto> get() {
        return betRepository.findAll().stream().map(this::toBetDto).collect(Collectors.toList());
    }

    @Override
    public BetDto getById(Long id) {
        return toBetDto(betRepository.findById(id).orElseThrow(BetNotFoundException::new));
    }

    @Override
    public void deleteById(Long id) {
        Bet bet = betRepository.findById(id).orElseThrow(BetNotFoundException::new);
        if(bet.getBetStatus() == BetStatus.NOT_STATE)
        {
            betRepository.deleteById(id);
        }
        else
        {
            throw new BetIsPlayedException();
        }
    }

    private void toBet(Bet bet, BetDto betDto)
    {
        bet.setBetStatus(betDto.getBetStatus());
        bet.setBetType(betDto.getBetType());
        bet.setRatio(betDto.getRatio());
        bet.setValue(betDto.getRatio());
        bet.setMatch(matchRepository.findById(betDto.getMatchId()).orElseThrow(MatchNotFoundException::new));
    }

    private BetDto toBetDto(Bet bet)
    {
        BetDto betDto = new BetDto();
        betDto.setBetType(bet.getBetType());
        betDto.setBetStatus(bet.getBetStatus());
        betDto.setRatio(bet.getRatio());
        betDto.setId(bet.getId());
        betDto.setMatchId(bet.getMatch().getId());
        return betDto;
    }
}
