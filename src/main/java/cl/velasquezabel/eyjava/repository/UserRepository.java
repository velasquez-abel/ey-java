package cl.velasquezabel.eyjava.repository;

import org.springframework.stereotype.Repository;

import  cl.velasquezabel.eyjava.entity.User;

@Repository
public interface UserRepository<User, Long > extends BaseRepository<User, Long>{

}
