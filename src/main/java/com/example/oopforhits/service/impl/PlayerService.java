package com.example.oopforhits.service.impl;

import com.example.oopforhits.model.Player;
import com.example.oopforhits.model.dto.PlayerDto;
import com.example.oopforhits.repository.PlayerRepository;
import com.example.oopforhits.service.RecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
public class PlayerService implements RecordsService<PlayerDto> {

    @Autowired
    private final PlayerRepository playerRepository;

    @Override
    public void add(PlayerDto item) {
        Player player = new Player();
        player.setName(item.getName());
        playerRepository.save(player);
    }

    @Override
    public void change(PlayerDto item) {
        Player player = playerRepository.getById(item.getId());
        player.setName(item.getName());
        playerRepository.save(player);
    }

    @Override
    public List<PlayerDto> get() {
        return playerRepository.findAll().stream().map(
                player -> {
                    PlayerDto playerDto = new PlayerDto();
                    playerDto.setName(player.getName());
                    playerDto.setId(player.getId());
                    return playerDto;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public PlayerDto getById(Long id) {
        Player player = playerRepository.getById(id);
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(id);
        playerDto.setName(player.getName());
        return playerDto;
    }

    @Override
    public void deleteById(Long id) {
        playerRepository.deleteById(id);
    }
}
