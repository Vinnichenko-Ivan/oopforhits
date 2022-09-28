package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.Player;
import com.example.oopforhits.data.model.dto.PlayerDto;
import com.example.oopforhits.domain.repositories.PlayerRepository;
import com.example.oopforhits.domain.services.RecordsService;
import exception.PlayerNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
        Player player = playerRepository.findById(item.getId())
                .orElseThrow(PlayerNotFoundException::new);
        player.setName(item.getName());
        playerRepository.save(player);
    }

    @Override
    public List<PlayerDto> get() {
        return playerRepository.findAll().stream().map(
                player -> {
                    PlayerDto playerDto = new PlayerDto(player.getName());
                    playerDto.setId(player.getId());
                    return playerDto;
                }
        ).collect(Collectors.toList());
    }

    @Override
    public PlayerDto getById(Long id) {
        Player player = playerRepository.findById(id)
                .orElseThrow(PlayerNotFoundException::new);
        PlayerDto playerDto = new PlayerDto(player.getName());
        playerDto.setId(id);
        return playerDto;
    }

    @Override
    public void deleteById(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new PlayerNotFoundException();
        }

    }
}
