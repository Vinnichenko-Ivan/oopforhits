package com.example.oopforhits.presentation.controllers;

import com.example.oopforhits.data.implementations.BetService;
import com.example.oopforhits.data.model.dto.BetDto;
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
@RequestMapping("/bet")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BetController implements RecordsController<BetDto> {

    private final BetService betService;

    @Override
    public void add(BetDto item) {
        betService.add(item);
    }

    @Override
    public void change(BetDto item) {
        betService.change(item);
    }

    @Override
    public List<BetDto> get() {
        return betService.get();
    }

    @Override
    public BetDto getById(Long id) {
        return betService.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        betService.deleteById(id);
    }
}
