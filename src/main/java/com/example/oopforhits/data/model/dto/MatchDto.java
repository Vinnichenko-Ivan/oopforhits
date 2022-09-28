package com.example.oopforhits.data.model.dto;

import com.example.oopforhits.data.model.enums.MatchStatus;
import com.example.oopforhits.data.model.enums.MatchType;
import lombok.Data;
import org.springframework.lang.NonNull;

/**
 * @author Ivan Vinnichenko
 */

@Data
public class MatchDto {
    private Long id;

    private MatchType type;
    @NonNull
    private Long leftTeamId;
    @NonNull
    private Long rightTeamId;

    private MatchStatus matchStatus;
}
