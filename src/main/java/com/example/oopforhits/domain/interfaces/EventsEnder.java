package com.example.oopforhits.domain.interfaces;

import com.example.oopforhits.data.model.enums.EndOfMatchType;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ivan Vinnichenko
 */

@Api
@RestController
@RequestMapping("/api")
public interface EventsEnder {

    @GetMapping("/EndEvent")
    void endEventById(Long id, EndOfMatchType endOfMatchType);
}
