package com.example.oopforhits.controller;

import com.example.oopforhits.model.Bet;
import com.example.oopforhits.model.dto.BetDto;
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
@RequestMapping("/bet")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class BetController implements RecordsController<BetDto> {
    @Override
    public void add(BetDto item) {

    }

    @Override
    public void change(BetDto item) {

    }

    @Override
    public List<BetDto> get() {
        return null;
    }

    @Override
    public BetDto getById(Long id) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
