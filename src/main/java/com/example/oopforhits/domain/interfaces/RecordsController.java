package com.example.oopforhits.domain.interfaces;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
@Api
@RestController
@RequestMapping("/api")
public interface RecordsController<T> {
    @PostMapping("/add")
    void add(T item);

    @PutMapping("/change")
    void change(T item);

    @GetMapping("/get")
    List<T> get();

    @GetMapping("/getByUUID")
    T getById(Long id);

    @DeleteMapping("/deleteByUUID")
    void deleteById(Long id);

}