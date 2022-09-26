package com.example.oopforhits.data.model.dto;

import com.example.oopforhits.data.model.enums.BetType;
import lombok.Data;

/**
 * @author Ivan Vinnichenko
 */
@Data
public class BetDto {
    private Long id;

    private Double value;

    private Double ratio;

    private BetType betType;

    private Long matchId;
}
