package com.example.oopforhits.presentation.controllers;

import com.example.oopforhits.data.implementations.TeamService;
import com.example.oopforhits.data.model.dto.TeamDto;
import com.example.oopforhits.domain.interfaces.RecordsController;
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
@RequestMapping("/team")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TeamController implements RecordsController<TeamDto> {

    private final TeamService teamService;

    @Override
    public void add(TeamDto item) {
        teamService.add(item);
    }

    @Override
    public void change(TeamDto item) {
        teamService.change(item);
    }

    @Override
    public List<TeamDto> get() {
        return teamService.get();
    }

    @Override
    public TeamDto getById(Long id) {
        return teamService.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        teamService.deleteById(id);
    }
}
