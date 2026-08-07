package com.example.dao;

import com.example.model.Ordine;

import java.util.List;

public interface IDao<T, ID> {
    void salva(T oggetto);

    T trovaPerId(ID id);

    List<T> trovaTutti();

    void aggiorna(T oggetto);

    void elimina(ID id);
}
