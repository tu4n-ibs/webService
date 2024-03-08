package org.example.springblogrestful.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<E>{
    Iterable<E> findAll();

    Optional<E> findById(int id);


    E save(E e);


    void remove(int id);
}
