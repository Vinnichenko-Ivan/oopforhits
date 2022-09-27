package com.example.oopforhits.presentation.controllers;

import com.example.oopforhits.data.implementations.MatchService;
import com.example.oopforhits.data.model.dto.MatchDto;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import com.example.oopforhits.domain.interfaces.EventsEnder;
import com.example.oopforhits.domain.interfaces.RecordsController;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/match")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MatchController implements EventsEnder, RecordsController<MatchDto> {

    private final MatchService matchService;

    @PostMapping("/end")
    @Override
    public void endEventById(Long id, EndOfMatchType endOfMatchType) {

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
