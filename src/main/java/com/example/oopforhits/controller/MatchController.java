package com.example.oopforhits.controller;

import com.example.oopforhits.model.Match;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MatchController implements EventsEnder, RecordsController<Match> {

    @PostMapping("/end")
    @Override
    public void endEventByUUID(UUID id) {

    }

    @Override
    public void add(Match item) {

    }

    @Override
    public void change(Match item) {

    }

    @Override
    public ArrayList<Match> get() {
        return null;
    }

    @Override
    public Match getByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteByUUID(UUID id) {

    }
}
