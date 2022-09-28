package com.example.oopforhits.domain.interfaces;

/**
 * @author Ivan Vinnichenko
 */

public interface SimpleMapperInterface<T, D> {
    void fromDto(T object, D dto);

    D toDto(T object);
}
