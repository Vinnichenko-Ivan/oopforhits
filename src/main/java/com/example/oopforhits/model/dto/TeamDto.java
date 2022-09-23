package com.example.oopforhits.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Set;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */

@Data
public class TeamDto {

    private Long id;

    private Set<Long> playersUUID;

    private String name;
}
