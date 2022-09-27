package com.example.oopforhits.data.implementations;

import com.example.oopforhits.data.model.dto.BetDto;
import com.example.oopforhits.domain.services.RecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Ivan Vinnichenko
 */
@Service
@RequiredArgsConstructor
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
