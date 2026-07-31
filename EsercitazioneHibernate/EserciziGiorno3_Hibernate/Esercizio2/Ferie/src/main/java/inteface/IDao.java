package inteface;

import entity.RichiestaFerie;
import enums.StatoRichiesta;

import java.util.List;

public interface IDao<T, ID> {

    void save(T entity);

    void saveAll(List<T> entity);

    void update(T entity);
}
