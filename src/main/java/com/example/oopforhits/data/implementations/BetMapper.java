package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Bet;
import com.example.oopforhits.data.model.dto.BetDto;
import com.example.oopforhits.domain.interfaces.SimpleMapperInterface;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Vinnichenko
 */
@Component
public class BetMapper implements SimpleMapperInterface<Bet, BetDto> {
    @Override
    public void fromDto(Bet object, BetDto dto) {
        object.setBetStatus(dto.getBetStatus());
        object.setBetType(dto.getBetType());
        object.setRatio(dto.getRatio());
        object.setValue(dto.getRatio());
    }

    @Override
    public BetDto toDto(Bet object) {
        BetDto betDto = new BetDto(object.getValue(), object.getRatio(), object.getBetType(), object.getMatch().getId(), object.getBetStatus());
        betDto.setId(object.getId());
        return betDto;
    }
}
