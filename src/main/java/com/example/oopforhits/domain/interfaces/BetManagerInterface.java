package com.example.oopforhits.domain.interfaces;

import com.example.oopforhits.data.model.Bet;
import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.enums.EndOfMatchType;

/**
 * @author Ivan Vinnichenko
 */

public interface BetManagerInterface {
    void matchEnded(Match match, EndOfMatchType endOfMatchType);

    void matchStarted(Match match);

    boolean betIsAccept(Bet bet);
}
