package com.example.oopforhits.data.model.dto;

import com.example.oopforhits.data.model.enums.BetStatus;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import lombok.Data;
import org.springframework.lang.NonNull;

/**
 * @author Ivan Vinnichenko
 */
@Data
public class BetDto {
    private Long id;

    @NonNull
    private Double value;
    @NonNull
    private Double ratio;
    @NonNull
    private EndOfMatchType betType;
    @NonNull
    private Long matchId;
    @NonNull
    private BetStatus betStatus;
}
