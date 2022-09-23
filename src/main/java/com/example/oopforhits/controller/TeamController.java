package com.example.oopforhits.controller;

import com.example.oopforhits.model.Team;
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
@RequestMapping("/team")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TeamController implements RecordsController<Team> {

    @Override
    public void add(Team item) {

    }

    @Override
    public void change(Team item) {

    }

    @Override
    public ArrayList<Team> get() {
        return null;
    }

    @Override
    public Team getByUUID(UUID id) {
        return null;
    }

    @Override
    public void deleteByUUID(UUID id) {

    }
}
