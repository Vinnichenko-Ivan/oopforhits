package com.example.oopforhits.presentation.controllers;

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
