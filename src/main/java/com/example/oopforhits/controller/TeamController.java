package com.example.oopforhits.controller;

import com.example.oopforhits.model.Team;
import com.example.oopforhits.model.dto.TeamDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/team")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TeamController implements RecordsController<TeamDto> {

    @Override
    public void add(TeamDto item) {

    }

    @Override
    public void change(TeamDto item) {

    }

    @Override
    public List<TeamDto> get() {
        return null;
    }

    @Override
    public TeamDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
