package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Match;
import com.example.oopforhits.data.model.dto.MatchDto;
import com.example.oopforhits.domain.interfaces.SimpleMapperInterface;
import org.springframework.stereotype.Component;

/**
 * @author Ivan Vinnichenko
 */
@Component
public class MatchMapper implements SimpleMapperInterface<Match, MatchDto> {
    @Override
    public void fromDto(Match object, MatchDto dto) {
        object.setType(dto.getType());
        object.setMatchStatus(dto.getMatchStatus());
    }

    @Override
    public MatchDto toDto(Match object) {
        MatchDto matchDto = new MatchDto(object.getLeftTeam().getId(), object.getRightTeam().getId());
        matchDto.setType(object.getType());
        matchDto.setId(object.getId());
        matchDto.setMatchStatus(object.getMatchStatus());
        return matchDto;
    }
}
