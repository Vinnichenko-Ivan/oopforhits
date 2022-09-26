package com.example.oopforhits.data.model.dto;

import lombok.Data;

import java.util.Set;

/**
 * @author Ivan Vinnichenko
 */

@Data
public class TeamDto {
    private Long id;

    private Set<Long> playersIdSet;

    private Set<Long> matchesIdSet;

    private String name;
}
