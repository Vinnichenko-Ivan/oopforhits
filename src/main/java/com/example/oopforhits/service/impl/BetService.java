package com.example.oopforhits.service.impl;

import com.example.oopforhits.model.dto.BetDto;
import com.example.oopforhits.service.RecordsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Service
public class BetService implements RecordsService<BetDto> {
    @Override
    public void add(BetDto item) {

    }

    @Override
    public void change(BetDto item) {

    }

    @Override
    public ArrayList<BetDto> get() {
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
