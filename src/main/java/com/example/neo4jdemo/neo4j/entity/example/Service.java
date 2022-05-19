package com.example.neo4jdemo.neo4j.entity.example;

public interface Service<T> {
    Iterable<T> findAll();

    T find(Long id);

    void delete(Long id);

    T createOrUpdate(T object);
}
