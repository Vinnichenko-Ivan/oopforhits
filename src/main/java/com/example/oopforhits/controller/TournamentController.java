package com.example.oopforhits.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/tournament")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class TournamentController implements EventsEnder{

    @PostMapping("/end")
    @Override
    public void endEventByUUID(UUID id) {

    }
}
