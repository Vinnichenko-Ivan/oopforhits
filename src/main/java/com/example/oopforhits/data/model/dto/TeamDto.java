package com.example.oopforhits.data.model.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author Ivan Vinnichenko
 */

@Data
public class TeamDto {
    private Long id;

    private Set<Long> playersId;

    private String name;
}
