package com.example.oopforhits.controller;

import com.example.oopforhits.model.Match;
import com.example.oopforhits.model.dto.MatchDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/match")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MatchController implements EventsEnder, RecordsController<MatchDto> {

    @PostMapping("/end")
    @Override
    public void endEventById(Long id) {

    }

    @Override
    public void add(MatchDto item) {

    }

    @Override
    public void change(MatchDto item) {

    }

    @Override
    public List<MatchDto> get() {
        return null;
    }

    @Override
    public MatchDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
