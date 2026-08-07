package com.example.dao;

import java.util.List;

public interface IDao <T>{
    public void inserisciTutti(List<T> tipo);

    public List<T> cercaTutti();

    public T cercaUno(Integer id);

    public void ModificaNome(Integer id, String modifica);

    public void CancellaUno(Integer id);
}
