package com.example.oopforhits.model.dto;

import com.example.oopforhits.model.enums.BetType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

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
