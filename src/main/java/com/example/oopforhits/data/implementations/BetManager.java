package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import com.example.oopforhits.domain.interfaces.BetManagerInterface;
import com.example.oopforhits.domain.repositories.BetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class BetManager implements BetManagerInterface {

    private final BetRepository betRepository;

    @Override
    public void BetsHandle(Match match, EndOfMatchType endOfMatchType) {
        betRepository.findAll();
    }
}
