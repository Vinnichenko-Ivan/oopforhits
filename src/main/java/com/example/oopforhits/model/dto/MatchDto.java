package com.example.oopforhits.model.dto;

import com.example.oopforhits.model.enums.MatchType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

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
