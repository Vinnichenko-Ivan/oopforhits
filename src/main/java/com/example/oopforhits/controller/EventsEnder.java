package com.example.oopforhits.controller;

import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */

@Api
@RestController
@RequestMapping("/api")
public interface EventsEnder {

    @GetMapping("/EndEvent")
    void endEventByUUID(UUID id);
}
