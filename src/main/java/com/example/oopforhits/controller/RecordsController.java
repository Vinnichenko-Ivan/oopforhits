package com.example.oopforhits.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/api")
public interface RecordsController<T> {

    @PostMapping("/add")
    void add(T item);

    @PostMapping("/change")
    void change(T item);

    @GetMapping("/get")
    ArrayList<T> get();

    @GetMapping("/getByUUID")
    T getByUUID(UUID id);

    @DeleteMapping("/deleteByUUID")
    void deleteByUUID(UUID id);

}
