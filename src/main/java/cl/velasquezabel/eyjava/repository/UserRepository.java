package cl.velasquezabel.eyjava.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import  cl.velasquezabel.eyjava.entity.User;

public interface UserRepository extends JpaRepository<User, UUID>{
}
