package com.example.oopforhits.data.model.dto;

import com.example.oopforhits.data.model.enums.MatchType;
import lombok.Data;

/**
 * @author Ivan Vinnichenko
 */

@Data
public class MatchDto {
    private Long id;

    private MatchType type;

    private Long leftTeamUUID;

    private Long rightTeamUUID;
}
