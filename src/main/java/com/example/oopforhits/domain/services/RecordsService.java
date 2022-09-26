package com.example.oopforhits.domain.services;

import java.util.List;

/**
 * @author Ivan Vinnichenko
 */
public interface RecordsService<T> {
    void add(T item);

    void change(T item);

    List<T> get();

    T getById(Long id);

    void deleteById(Long id);

}
