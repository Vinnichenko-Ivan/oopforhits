package com.example.oopforhits.data.model.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class PlayerDto {
    private Long id;
    @NonNull
    private String name;
}
