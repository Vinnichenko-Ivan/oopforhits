package com.example.oopforhits.controller;

import com.example.oopforhits.model.Tournament;
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
@RequestMapping("/tournament")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TournamentController implements EventsEnder, RecordsController<Tournament>{

    @PostMapping("/end")
    @Override
    public void endEventByUUID(UUID id) {

    }

    @Override
    public void add(Tournament item) {

    }

    @Override
    public void change(Tournament item) {

    }

    @Override
    public ArrayList<Tournament> get() {
        return null;
    }

    @Override
    public Tournament getByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteByUUID(UUID id) {

    }
}
