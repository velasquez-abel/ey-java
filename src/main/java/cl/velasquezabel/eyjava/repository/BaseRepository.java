package cl.velasquezabel.eyjava.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID>{
	  T findOne(ID id);
	  T save(T entity);
}
