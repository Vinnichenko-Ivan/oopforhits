package com.example.oopforhits.controller;

import com.example.oopforhits.model.Bet;
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
@RequestMapping("/bet")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BetController implements RecordsController<Bet> {
    @Override
    public void add(Bet item) {

    }

    @Override
    public void change(Bet item) {

    }

    @Override
    public ArrayList<Bet> get() {
        return null;
    }

    @Override
    public Bet getByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteByUUID(UUID id) {

    }
}
