package cl.velasquezabel.eyjava.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T, ID>{
	  T findOne(ID id);
	  T save(T entity);
}
