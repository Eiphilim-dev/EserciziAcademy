package dao;

import java.util.List;

public interface IDao<T, ID>{
     void save(T entity);

     void saveAll(List<T> entity);

     T findByIdentification(ID identification);

     List<T> findAll();
}
