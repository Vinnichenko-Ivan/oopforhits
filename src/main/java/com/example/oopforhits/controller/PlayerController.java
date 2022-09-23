package com.example.oopforhits.controller;

import com.example.oopforhits.model.dto.PlayerDto;
import com.example.oopforhits.service.impl.PlayerService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PlayerController implements RecordsController<PlayerDto> {

    private final PlayerService playerService;

    @Override
    public void add(PlayerDto item) {
        playerService.add(item);
    }

    @Override
    public void change(PlayerDto item) {
        playerService.change(item);
    }

    @Override
    public List<PlayerDto> get() {
        return playerService.get();
    }

    @Override
    public PlayerDto getById(Long id) {
        return playerService.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        playerService.deleteById(id);
    }
}
