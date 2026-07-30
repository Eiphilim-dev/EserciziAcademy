package com.gestione.dao;

import java.util.List;

public interface IDao <T, ID>{
    void save(T entity);

    void saveAll(List<T> entity);

    T findById(ID id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);

    void deleteAll();
}
