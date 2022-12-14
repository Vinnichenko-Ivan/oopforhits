package com.example.oopforhits.presentation.controllers;

import com.example.oopforhits.data.implementations.MatchService;
import com.example.oopforhits.data.model.dto.MatchDto;
import com.example.oopforhits.data.model.enums.EndOfMatchType;
import com.example.oopforhits.domain.interfaces.RecordsController;
import com.example.oopforhits.domain.interfaces.StartEndEvents;
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
@RequestMapping("/match")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class MatchController implements StartEndEvents, RecordsController<MatchDto> {

    private final MatchService matchService;

    @Override
    public void endEventById(Long id, EndOfMatchType endOfMatchType) {
        matchService.endMatchById(id, endOfMatchType);
    }

    @Override
    public void startEventById(Long id) {
        matchService.startMatchById(id);
    }

    @Override
    public void add(MatchDto item) {
        matchService.add(item);
    }

    @Override
    public void change(MatchDto item) {
        matchService.change(item);
    }

    @Override
    public List<MatchDto> get() {
        return matchService.get();
    }

    @Override
    public MatchDto getById(Long id) {
        return matchService.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        matchService.deleteById(id);
    }
}
