package com.example.oopforhits.domain.interfaces;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.enums.EndOfMatchType;

/**
 * @author Ivan Vinnichenko
 */

public interface BetManagerInterface {
    void BetsHandle(Match match, EndOfMatchType endOfMatchType);

}
