package com.example.oopforhits.controller;

import com.example.oopforhits.model.Player;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/player")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class PlayerController implements RecordsController<Player> {

    @Override
    public void add(Player item) {

    }

    @Override
    public void change(Player item) {

    }

    @Override
    public ArrayList<Player> get() {
        return null;
    }

    @Override
    public Player getByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteByUUID(UUID id) {

    }
}
